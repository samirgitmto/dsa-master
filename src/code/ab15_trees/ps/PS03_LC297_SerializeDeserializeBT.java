package code.ab15_trees.ps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import code.ab15_trees.ps.Codec.TreeNode;
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
	
	public static void main(String[] args) {
//		Node root = deserialize("[1,2,3,null,null,6,5]");
		Node root = deserialize("[1,2]");
		traverse(root);
		System.out.println();
		
		String serializedArr = serialize(root);
		System.out.println(serializedArr);
//		[1, 2, 3, null, null, 6, 5, null, null, null, null]
		
		Codec codec = new Codec();
		TreeNode root2 = codec.deserialize("[1,2,3,null,null,4,5]");
//		traverse(root2);
		System.out.println();
		
		String serializedArr2 = codec.serialize(root2);
		System.out.println(serializedArr2);
	}
}

/**
 * DFS preorder is an alternative with recursion - NEXT To be done
 * less branching
 * Time & Space Complexity - O(n)
 * @since 18-04-2026
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if (root == null)	return "";
        List<Integer> integers = new ArrayList<Integer>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
        	TreeNode poll = queue.poll();
        	if (poll == null) {
        		integers.add(null);
        		continue;
        	}
        	integers.add(poll.val);
        	
//        	if (poll.left != null)	queue.offer(poll.left);
//        	if (poll.right != null)	queue.offer(poll.right);
        	queue.offer(poll.left);
        	queue.offer(poll.right);
        }
        
        // trim remaining nulls
        integers = trimTrailingNulls(integers);
        
        String collect = integers.stream()
        		.map(String::valueOf)
        		.collect(Collectors.joining(","));
        collect = "[" + collect + "]";
        return collect;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isBlank())	return null;
        
        data = data.substring(1, data.length()-1);
        Queue<TreeNode> queue = new LinkedList<Codec.TreeNode>();
        String[] split = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < split.length) {
        	TreeNode poll = queue.poll();
        	if (i < split.length && !split[i].equals("null")) {
        		poll.left = new TreeNode(Integer.parseInt(split[i]));
        		queue.offer(poll.left);
        	}
        	i++;
        	if (i < split.length && !split[i].equals("null")) {
        		poll.right = new TreeNode(Integer.parseInt(split[i]));
        		queue.offer(poll.right);
        	}
        	i++;
        }
        
        return root;
    }
    
    private static List<Integer> trimTrailingNulls(List<Integer> list) {
		int i = list.size() - 1;
		while (i >= 0 && list.get(i) == null) {
			i--;
		}
		list = list.subList(0, i+1);
		return list;
	}
    
    static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    	}
}