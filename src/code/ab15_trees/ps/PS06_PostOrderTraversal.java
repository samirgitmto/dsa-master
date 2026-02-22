package code.ab15_trees.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Bit complex iterative traversal than other 2 as it requires a Node to be visited twice.
 * @author Mohammad Samir
 * @since 21-11-2025
 */
public class PS06_PostOrderTraversal {

	/**
	 * using lastVisited pointer and a Stack
	 * @param root
	 */
	static void postOrder(Node root) {
		if (root == null)	return;
		
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		Node lastVisited = null;
		
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				Node peek = stack.peek();
				// CASE 1: right child exists and is not processed yet
				if (peek.right != null && peek.right != lastVisited) {
					current = peek.right;
				}
				// CASE 2: right is null OR already processed
				else {
					System.out.print(peek.val + " ");
					lastVisited = stack.pop();
				}
			}
		}
	}
	
	static List<Integer> postOrderUsing2Stacks(Node root) {
		if (root == null)	return new ArrayList<Integer>();
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(root);
		
		while (!stack1.isEmpty()) {
			Node currentNode = stack1.pop();
			stack2.push(currentNode);
			
			if (currentNode.left != null)
				stack1.push(currentNode.left);
			if (currentNode.right != null)
				stack1.push(currentNode.right);
		}
		
		List<Integer> postOrderList = new ArrayList<Integer>();
		while(!stack2.isEmpty()) {
			postOrderList.add(stack2.pop().val);
		}
		
		return postOrderList;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		postOrder(root);
		postOrderUsing2Stacks(root);
	}
}
