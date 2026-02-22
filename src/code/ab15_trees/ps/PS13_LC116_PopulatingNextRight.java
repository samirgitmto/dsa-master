package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * populating next to null if no nodes in the current level else to to the next node
 * BFS approach using Queue
 * 
 * @since 23-11-2025
 */
public class PS13_LC116_PopulatingNextRight {

	/**
	 * BFS approach using Queue
	 * Complexity:
	 *  Time - O(n)
	 *  Space - O(n)
	 * @param root
	 * @return
	 */
	static Node2 connectBFS(Node2 root) {
        if (root == null)    return null;
		
		Queue<Node2> queue = new ArrayDeque<Node2>();
		Node2 node = root;
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			
			for (int i = 0; i < levelSize; i++) {
				Node2 current = queue.poll();
				if (i < levelSize-1) {
					current.next = queue.peek();
				}
				else {
					current.next = null;
				}
				
				if (current.left != null)	queue.offer(current.left);
				if (current.right != null)	queue.offer(current.right);
			}
		}
		return node;
    }
	
	/**
	 * Level by Level Pointer linking approach
	 * Complexity:
	 *  Space - O(1)
	 * @param root
	 * @return
	 */
	static Node2 connect2Ptrs(Node2 root) {
        if (root == null)    return null;
        Node2 level = root;
        
        while (level.left != null) {
        	Node2 current = level;
        	
        	while (current != null) {
        		current.left.next = current.right;
        		
        		if (current.next != null) {
        			current.right.next = current.next.left;
        		}
        		
        		current = current.next;
        	}
        	
        	level = level.left;
        }
        
        return root;
	}
	
	public static void main(String[] args) {
		Node2 root = new Node2(1);
		root.left = new Node2(2);
		root.right = new Node2(3);		
		root.left.left = new Node2(4);
		root.left.right = new Node2(5);
		Node2 connectedRoot = connectBFS(root);
		System.out.println(connectedRoot.next);
		System.out.println(connectedRoot.left.next);
		System.out.println(connectedRoot.right.next);
	}
}

class Node2 {
	int val;
	Node2 left, right, next;
	public Node2(int x) {
		this.val = x;
	}
}