package code.ab15_trees;

import java.util.Stack;

/**
 * store right first in the stack (simpler version).
 * @author Mohammad Samir
 * @since 20 Sep 2025
 */
public class BT03_PreOrderIterative2 {

	static void rightBeforeTraversePreOrder(Node head) {
		Node current = head;
		Stack<Node> st = new Stack<Node>();
		
		while (current!=null || !st.isEmpty()) {
			if (current.right!=null)
				st.push(current.right);
			System.out.print(current.val + " ");
			if (current.left!=null) {
				current = current.left;
			}
			else {
				if (!st.isEmpty())
					current = st.pop();
				else
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.left.right.right = new Node(6);
		head.left.right.right.right = new Node(7);
		rightBeforeTraversePreOrder(head);
	}
	
}
