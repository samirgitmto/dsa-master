package code.ab15_trees.ps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import code.ab15_trees.ps.PS01_QueueBT.Node;

/**
 * Construction of Binary Tree using an Integer array of elements and a Queue for level order insertion.
 * 
 * @author Mohammad Samir
 * @since 21-11-2025
 */
public class PS02_LevelOrderBT {

	/**
	 * 
	 * @param arr
	 * @return root of constructed BT
	 */
	static Node create(Integer[] arr) {
		if (arr == null || arr.length==0 || arr[0]==null) {
			return null;
		}
		
		Queue<Node> queue = new LinkedList<>();
		Node root, current;
		root = new Node(arr[0]);
		queue.offer(root);
		int i = 1;
		while (!queue.isEmpty() && i < arr.length) {
			current = queue.poll();
			if (arr[i] != null) {
				current.left = new Node(arr[i]);
				queue.offer(current.left);
			}
			i++;
			if (arr[i] != null) {
				current.right = new Node(arr[i]);
				queue.offer(current.right);
			}
			i++;
		}
		
		return root;
	}
	
	static Integer[] serializeIntoArray(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
		queue.offer(root);
		Node current;
		
		while (!queue.isEmpty()) {
			current = queue.poll();
			
			if (current.left != null) {
				list.add(current.left.val);
				queue.offer(current.left);
			}
			else {
				list.add(null);
			}
			if (current.right != null) {
				list.add(current.right.val);
				queue.offer(current.right);
			}
			else {
				list.add(null);
			}
		}
		
		
		list = trimTrailingNulls(list);
		
		return list.toArray(new Integer[0]);
	}
	
	private static List<Integer> trimTrailingNulls(List<Integer> list) {
		int i = list.size() - 1;
		while (i >= 0 && list.get(i) == null) {
			list = list.subList(0, i);
			i--;
		}
		return list;
	}

	public static void main(String[] args) {
		Node root = create(new Integer[]{1, 2, 3, null, null, 6, 5});
		traverse(root);
		System.err.println();
		
		Integer[] serializedArr = serializeIntoArray(root);
		System.out.println(Arrays.toString(serializedArr));
//		[1, 2, 3, null, null, 6, 5, null, null, null, null]
	}
	
	static void traverse(Node head) {
		if (head != null) {
			System.out.print(head.val + " ");
			traverse(head.left);
			traverse(head.right);
		}
	}
	
	static class Node {
		int val;
		Node left, right;
		public Node(int x) {
			this.val = x;
		}
	}
}
