package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @since 29-11-2025
 */
public class PS20_LC993_Cousins {

	/**
	 * BFS
	 * Complexity: Time		Space
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	static boolean isCousins(Node root, int x, int y) {
		if (root == null)	return false;
		
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(root);
				
		Node parentX = null;
		Node parentY = null;
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			
			for (int i = 0; i < levelSize; i++) {
				Node current = queue.poll();
				
				if (current.left != null) {
					if (current.left.val == x)	parentX = current;
					if (current.left.val == y)	parentY = current;
					queue.offer(current.left);
				}
				if (current.right != null) {
					if (current.right.val == x) parentX = current;
					if (current.right.val == y)	parentY = current;
					queue.offer(current.right);
				}
			}
			
			if (parentX != null ^ parentY != null) {
				return false;
			}
			if (parentX != null && parentY != null) {
				return parentX != parentY;
			}
			
			parentX = null;
			parentY = null;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.right = new Node(3);
		root.right.right = new Node(5);
		
		System.out.println(isCousins(root, 2, 3));
		System.out.println(isCousins(root, 4, 5));
	}
}