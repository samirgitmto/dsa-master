package code.ab15_trees;

import java.util.Stack;

/**
 * for iterative traversal in pre order manner, use stack
 * traverse root elements and left child.
 * store roots in stack to traverse the right child.
 * @author Mohammad Samir
 * @since 08 Sep 2025
 */
public class BT03_PreOrderIterative {

	static void preOrderTraversalIter(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node current = head;
		while (current!=null || !stack.isEmpty()) {
			if (current!=null) {
				System.out.print(current.val + " ");
				stack.push(current);
				current = current.left;
			}
//			else if (current==null) {
			else {
				current = stack.pop();
				current = current.right;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		preOrderTraversalIter(head);
	}
}
class Node {
	int val;
	Node left, right;
	public Node(int x) {
		this.val = x;
	}
}