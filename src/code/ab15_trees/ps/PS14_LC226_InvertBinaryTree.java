package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Approaches:
 * 1. BFS (Level Order Traversal)
 * Idea: Use a queue. For each node, swap its left and right children, then push its children into the queue.
 * 2.DFS using Stack (Iterative Preorder)
 * Idea: Simulate recursion using an explicit stack.
 * 3. DFS using Postorder Iterative (Less common)
 * Idea: Postorder ensures children are processed before the parent.
 * 4. DFS using Postorder Recursive (very common)
 * @since 23-11-2025
 */
public class PS14_LC226_InvertBinaryTree {

	/**
	 * 
	 * @param root
	 * @return
	 */
	static Node invertTreeDfsRec(Node root) {
		if (root == null)	return root;
		
		invertTreeDfsRec(root.left);
		invertTreeDfsRec(root.right);
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		return root;
	}
	
	static Node invertTreeBFS(Node root) {
		if (root == null) return null;
		
		Queue<Node> queue = new ArrayDeque<Node>();
		
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			
			Node temp = current.left;
			current.left = current.right;
			current.right = temp;
			
			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}
		return root;
	}
	
	/**
	 * using Stack - iterative preorder
	 * 
	 * Iterative code looks like it might be doing level-by-level, but it is NOT BFS.
	 * It is DFS, because the data structure used is a stack, not a queue.
	 * Visiting order goes “deep” before “wide”.
	 * 
	 * @param root
	 * @return
	 */
	static Node invertTreeDFSIter(Node root) {
		if (root == null)	return null;
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			Node current = stack.pop();
//			System.err.println("node processed: " + current.val);
			
			Node temp = current.left;
			current.left = current.right;
			current.right = temp;
			
			if (current.left != null)
				stack.push(current.left);
			if (current.right != null)
				stack.push(current.right);
		}
		
		return root;
	}

	
	static void traverseLevelOrder(Node root) {
		if (root == null)	return;
		
		Queue<Node> queue = new ArrayDeque<Node>();
		
		System.out.print(root.val + " ");
		queue.offer(root);
		
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
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		traverseLevelOrder(root);
//		invertTreeDfsRec(root);
//		invertTreeBFS(root);
		invertTreeDFSIter(root);
		traverseLevelOrder(root);
		
	}
}