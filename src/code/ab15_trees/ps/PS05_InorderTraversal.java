package code.ab15_trees.ps;

import java.util.Stack;

/**
 * 
 * @since 21-11-2023
 */
public class PS05_InorderTraversal {

	static void iterInorderTraverse(Node root) {
		if (root == null)	return;
		
		Stack<Node> stack = new Stack<Node>();
		
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			
			// accumulate left into stack
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			
			// pop and visit
			current = stack.pop();
			System.out.print(current.val + " ");
			
			// go right
			current = current.right;
		}
		System.out.println();
	}
	
	static void iterInorder(Node root) {
		if (root == null)	return;
		
		Stack<Node> stack = new Stack<Node>();
		
		Node current = root;
		
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				current = stack.pop();
				System.out.print(current.val + " ");
				current = current.right;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.right.right = new Node(5);
		iterInorderTraverse(root);
		iterInorder(root);
	}
	
}