package code.ab15_trees.ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import code.ab15_trees.ps.april.PS01_QBT;

/**
 * constructing a Binary Tree using Queue in iterative manner
 * 
 * @author Mohammad Samir
 * @since 21-11-2-25
 */
public class PS01_QueueBT {

	static Node create() {
		Node root, current;
		Queue<Node> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the root value");
		int x = sc.nextInt();
		root = new Node(x);
		queue.offer(root);
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println("enter left child value");
			x = sc.nextInt();
			if (x != -1) {
				Node left = new Node(x);
				current.left = left;
				queue.offer(left);
			}
			System.out.println("enter right child value");
			x = sc.nextInt();
			if (x != -1) {
				Node right = new Node(x);
				current.right = right;
				queue.offer(right);
			}
		}
		return root;
	}
	
	static void traverse(Node head) {
		if (head != null) {
			System.out.print(head.val + " ");
			traverse(head.left);
			traverse(head.right);
		}
	}
	
	
	/**
	 * can be improved using level size with the main Invariant being the Queue always contains nodes of the next level.
	 * @param root
	 */
	static void levelOrderTraversalV1(TreeNode root) {
		if (root == null)	return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode poll = queue.poll();
			System.out.println(poll.val);
			if (poll.left != null)	queue.offer(poll.left);
			if (poll.right != null)	queue.offer(poll.right);
		}
	}
	
	/**
	 * LC 102. Binary Tree Level Order Traversal
	 * The main Invariant is that the Queue always has all nodes of the next level.
	 * @param root
	 * @return
	 * @since 18-04-2026
	 */
	static List<List<Integer>> levelOrderTraversal(TreeNode root) {
		if (root == null) return Collections.emptyList();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> current = new ArrayList<Integer>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode poll = queue.poll();
				System.out.print(poll.val + " ");
				current.add(poll.val);
				
				if (poll.left != null)	queue.offer(poll.left);
				if (poll.right != null)	queue.offer(poll.right);
			}
			list.add(current);
			System.out.println();
		}
		
		return list;
	}
	
	/**
	 * LC 103. Binary Tree Zigzag Level Order Traversal
	 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right,
	 *  then right to left for the next level and alternate between).
	 *  
	 *  Use a flag and then add accordingly to the LinkedList
	 * @param root
	 * @since 18-04-2026
	 */
    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if (root == null) return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> current = new LinkedList<Integer>();
//			List<Integer> current = new ArrayList<Integer>();
			for (int i = 0; i < levelSize; i++) {
				TreeNode poll = queue.poll();
				
				// normal
				if (leftToRight)	current.add(poll.val);
				// reversed
				else	current.addFirst(poll.val);
				
				if (poll.left != null)	queue.offer(poll.left);
				if (poll.right != null)	queue.offer(poll.right);
			}
			leftToRight = !leftToRight; // flipped
			list.add(current);
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		Node root = create();
		
		traverse(root);
		
		
	}
	
	static class Node {
		int val;
		Node left, right;
		public Node(int x) {
			this.val = x;
		}
	}
	static class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int x) {
			this.val = x;
		}
	}
}
