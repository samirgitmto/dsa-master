package code.ab14_queue.ps;

import java.util.HashMap;
import java.util.Map;

/**
 *  * We need:
 * get(key) → return value, mark as recently used
 * put(key, value) → insert/update, mark as recently used
 * If capacity exceeded → evict least recently used (LRU)
 * **** And everything must be O(1)
 * 
 * 1. Using only HashMap
 * get → O(1)
 * But how do you track LRU order?
 * 2. Using only list
 * Maintain order
 * But lookup is O(n)
 * That's why Hashmap & Doubly LinkedList are used.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * HashMap gives O(1) lookup of nodes by key. 
 * Doubly Linked List gives O(1) removal & insertion at both ends
 * 1. HashMap maps key → node
 * 2. DLL maintains usage order:
 * 		head = most recently used 
 * 		tail = least recently used
 * 
 * COMMON PITFALLS
 * Common Interview Pitfalls
 * -> Using Singly Linked List: removal is O(n)
 * -> Forgetting to update map when deleting: memory leak / wrong answers
 * -> Not handling update case separately: duplicate nodes bug
 */
public class PS10_LC146_LRUCache {
	Node head;
	Node tail;
	HashMap<Integer, Node> hashMap;
	int size;
	
	public PS10_LC146_LRUCache(int capacity) {
        this.hashMap = new HashMap<Integer, PS10_LC146_LRUCache.Node>(capacity, 1);
        this.size = capacity;
    }
    
	public int get(int key) {
		if (!hashMap.isEmpty() && hashMap.containsKey(key)) {
			Node foundNode = hashMap.get(key);
			
			moveToHead(foundNode);
			
			return foundNode.val;
		}
		return -1;
	}
    
    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
        	Node foundNode = hashMap.get(key);
        	foundNode.val = value;
        	moveToHead(foundNode);
        }
        else {
        	addToHead(new Node(key, value));
        }
        if (hashMap.size() > size) {
        	Node removedNode = tail;
        	hashMap.remove(tail.key);
        	removeNode(removedNode);
        }
    }
	
    private void moveToHead(Node node) {	
		removeNode(node);
		
		addToHead(node);
	}
    

    private void addToHead(Node node) {
    	hashMap.put(node.key, node);
    	node.prev = null;
    	node.next = head;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		
		if (tail == null) {
			tail = node;
		}
		
	}

	// 1 ---- 2 ----- 3
    // 1 -- 3
    private void removeNode(Node node) {
    	// head
    	if (node.prev == null) {
    		head = node.next;
    		if (node.next != null)
    			node.next.prev = null;
    	}
    	// tail
    	else if (node.next == null) {	
    		tail = node.prev;
    		node.prev.next = null;
    	}
    	else {
    		node.prev.next = node.next;
    		node.next.prev = node.prev;
    	}
    	node.next = null;
    	node.prev = null;
    }

	public static void main(String[] args) {
//    	PS10_LC146_LRUCache lruCache = new PS10_LC146_LRUCache(2);
    	LRUCache lruCache = new LRUCache(2);
    	lruCache.put(1, 10);
    	lruCache.put(2, 20);
    	System.out.println(lruCache.get(1));
    	lruCache.put(3, 30);
    	System.out.println(lruCache.get(2));
	}
 
    static class Node {
    	int key, val;
    	Node prev, next;
    	public Node(int x) {
			this.val = x;
		}
    	public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
    }
}

/**

* Observation:
* The current removeNode() implementation explicitly handles multiple edge cases:
* 1. Node is head
* 2. Node is tail
* 3. Node is in the middle
* 4. Node is the only element
*
* While correct, this leads to multiple conditional branches, making the code:
* * Harder to reason about under pressure
* * More error-prone (easy to miss pointer updates)
* * Verbose and less maintainable
*
* Interview Insight:
* A strong signal is recognizing that these edge cases arise only because
* we are using real head and tail pointers.
*
* Improved Approach (Dummy Nodes):
* Introduce two sentinel (dummy) nodes:
* * dummyHead (before actual head)
* * dummyTail (after actual tail)
*
* Structure becomes:
* dummyHead <-> ... real nodes ... <-> dummyTail
*
* Benefits:
* * No node is ever truly at "boundary"
* * Every node has both prev and next
* * Uniform insertion and deletion logic
* * Eliminates ALL branching in removeNode()
*
* Simplified removeNode():
* node.prev.next = node.next;
* node.next.prev = node.prev;
*
* Simplified addToHead():
* node.next = dummyHead.next;
* node.prev = dummyHead;
* dummyHead.next.prev = node;
* dummyHead.next = node;
*
* Additional Notes:
* * dummyHead.next is always the MRU node
* * dummyTail.prev is always the LRU node
* * Eviction becomes: remove(dummyTail.prev)
*
* Conclusion:
* Using dummy nodes converts a multi-branch, edge-case-heavy implementation
* into a clean, uniform O(1) design — which is the preferred approach in interviews.
  */

class LRUCache {

	Node head, tail;
	int size;
	Map<Integer, Node> map;
	
    public LRUCache(int capacity) {
        size = capacity;
        this.map = new HashMap<Integer, LRUCache.Node>(size, 1);
    }
    
    public int get(int key) {
        if (!map.containsKey(key))	return -1;
        Node node = map.get(key);
        // MRU
        moveToHead(node);
        
        return node.val;
    }
    
    private void moveToHead(Node node) {
		removeNode(node);
		addToHead(node);
	}

	private void addToHead(Node node) {
		if (head == null) {
			head = node;
			tail = node;
			return;
		}
		
		node.prev = null;  // not really needed as removeNode is called first when it has previous Node. Otherwise called for new entry.
		node.next = head;
		head.prev = node;
		head = node;
	}

	private void removeNode(Node node) {
		// head
		if (node.prev == null) {
			if (node.next != null) {
				head = node.next;
				node.next.prev = null;
				node.next = null;
			}
			else {  // single node
				head = tail = null;
			}
		}
		else if (node.next == null && node.prev != null) {   // tail
			tail = node.prev;
			node.prev.next = null;
			node.prev = null;
		}
		else { // middle
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		node.prev = null;
		node.next = null;
	}

	public void put(int key, int value) {
        if (map.containsKey(key)) {
        	Node node = map.get(key);
        	node.val = value;
        	// MRU
        	moveToHead(node);
        }
        else {
        	Node node = new Node(key, value);
        	map.put(key, node);
			addToHead(node);
        }
        if (map.size() > size) {
        	// LRU
//        	map.remove(tail.key);
//        	removeNode(tail); instead
        	Node lru = tail;
        	removeNode(lru);
        	map.remove(lru.key);
        }
    }
    
    static class Node {
    	int key, val;
    	Node next, prev;
    	public Node(int x) {
			this.val = x;
		}
    	
    	public Node(int key, int val) {
    		this.key = key;
    		this.val = val;
    	}
    }
}