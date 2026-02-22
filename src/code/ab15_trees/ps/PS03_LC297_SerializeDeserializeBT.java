package code.ab15_trees.ps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import code.ab15_trees.ps.PS02_LevelOrderBT.Node;

public class PS03_LC297_SerializeDeserializeBT {

	static Node deserialize(String data) {
		data = data.substring(1, data.length()-1);
		String[] split = data.split(",");
		Integer[] arr = Arrays.stream(split).map(e -> {
			if (e.equals("null"))
				return null;
			else
				return Integer.parseInt(e);
			}
				).collect(Collectors.toList()).toArray(new Integer[0]);
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
			if (i<arr.length && arr[i] != null) {
				current.right = new Node(arr[i]);
				queue.offer(current.right);
			}
			i++;
		}
		
		return root;
	}
	
	static String serialize(Node root) {
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
		
		String collect = list.stream().map(e -> e + "").collect(Collectors.joining(","));
		collect = "[" + collect + "]";
		
		return collect;
	}
	
	private static List<Integer> trimTrailingNulls(List<Integer> list) {
		int i = list.size() - 1;
		while (i >= 0 && list.get(i) == null) {
			i--;
		}
		list = list.subList(0, i+1);
		return list;
	}

	public static void main(String[] args) {
//		Node root = deserialize("[1,2,3,null,null,6,5]");
		Node root = deserialize("[1,2]");
		traverse(root);
		System.out.println();
		
		String serializedArr = serialize(root);
		System.out.println(serializedArr);
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