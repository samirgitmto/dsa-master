package code.ab15_trees.ps;

import java.util.Stack;

/**
 * 
 * @since 21-11-2025
 */
public class PS04_PreorderTraversal {

	static void iterativePreorder(Node root) {
		if (root == null)	return;
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			root = stack.pop();
			
			System.out.print(root.val + " ");
			
			if (root.right != null)
				stack.push(root.right);
			if (root.left != null)
				stack.push(root.left);
		}
		System.out.println();
	}
	
	static void iterativePreorderV1(Node root2) {
		if (root2 == null)	return;
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root2);
		Node root = null;
		while (!stack.isEmpty()) {
			if (root == null) {
				root = stack.pop();
			}
			System.out.print(root.val + " ");
			if (root.right != null) {
				stack.push(root.right);
			}
			root = root.left;	// over complicated
		}
	}
	
	static void recPreorderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.val);
			recPreorderTraversal(root.left);
			recPreorderTraversal(root.right);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		iterativePreorder(root);
//		iterativePreorderV1(root);
//		recPreorderTraversal();
	}
}

class Node {
	int val;
	Node left, right;
	public Node(int x) {
		this.val = x;
	}
}