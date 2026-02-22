package code.ab14_queue.ps;

import java.util.HashMap;

/**
 * 
 * The functions get and put must each run in O(1) average time complexity.
 * HashMap gives O(1) lookup of nodes by key. 
 * Doubly Linked List gives O(1) removal & insertion at both ends
 * 1. HashMap maps key → node
 * 2. DLL maintains usage order:
 * 		head = most recently used 
 * 		tail = least recently used
 */
public class PS10_LC146_LRUCache {
	Node head;
	Node tail;
	HashMap<Integer, Node> hashMap;
	int size;
	
	public PS10_LC146_LRUCache(int capacity) {
        this.hashMap = new HashMap<Integer, PS10_LC146_LRUCache.Node>(capacity);
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
//		Node foundNode = hashMap.get(key);
//    	foundNode.val = value;		
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
    	PS10_LC146_LRUCache lruCache = new PS10_LC146_LRUCache(2);
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