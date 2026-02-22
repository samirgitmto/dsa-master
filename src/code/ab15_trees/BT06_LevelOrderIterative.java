package code.ab15_trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue will be used with continuous enqueue & dequeue.
 * @author Mohammad Samir
 * @since 20 Sep 2025
 */
public class BT06_LevelOrderIterative {

	static void levelOrderIterative(Node head) {
		Queue<Node> queue = new LinkedList<Node>();
		System.out.print(head.val + " ");
		queue.offer(head);
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.left != null) {
				System.out.print(current.left.val + " ");
				queue.offer(current.left);
			}
			if (current.right != null) {
				System.out.print(current.right.val + " ");
				queue.offer(current.right);
			}
		}
		System.err.println();
	}
	// can be improved
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.left.right.left = new Node(6);
		head.left.right.right = new Node(7);
		levelOrderIterative(head);
	}	
}