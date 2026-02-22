package code.ab15_trees.ps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
}
