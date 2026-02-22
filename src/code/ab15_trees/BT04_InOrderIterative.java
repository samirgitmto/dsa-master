package code.ab15_trees;

import java.util.Stack;

public class BT04_InOrderIterative {

	static void inOrderIterative(Node head) {
		Stack<Node> st = new Stack<Node>();
		Node current = head;
		
		while (current != null || !st.isEmpty()) {
			if (current != null) {
//				keep going left
				st.push(current);
				current = current.left;
			}
			else {
//				backtrack
				current = st.pop();
				System.out.print(current.val + " ");
				current = current.right;
			}
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.left.right.left = new Node(6);
		head.left.right.right = new Node(7);
		inOrderIterative(head);
	}
	
}