package code.ab15_trees.ps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * construction of Binary Tree using Preorder and Inorder traversals arrays
 * @since 22-11-2025
 */
public class PS08_LC105_BTFromPrenIn {

	static int preIndex = 0;
	
	public static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = createMap(inorder);
        
        preIndex = 0;  
        return helper(0, preorder.length-1, preorder, inorder, inorderMap);
    }
	
	private static Node helper(int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap) {
		if (inStart > inEnd || preIndex > preorder.length-1)	return null;
		
		int rootValue = preorder[preIndex];
		preIndex++;
		
		Node root = new Node(rootValue);
		
		int inIndex = inorderMap.get(rootValue);
		
		root.left = helper(inStart, inIndex-1, preorder, inorder, inorderMap);
		root.right = helper(inIndex+1, inEnd, preorder, inorder, inorderMap);
		
		return root;
	}
	
	// have to investigate the preIndex passing problem here
	private static Node helper0(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap) {
		if (inStart > inEnd || preIndex > preorder.length-1)	return null;
		
		int rootValue = preorder[preIndex];
		preIndex++;
		
		Node root = new Node(rootValue);
		
		int inIndex = inorderMap.get(rootValue);
		
//		root.left = helper(preIndex, inStart, inIndex-1, preorder, inorder, inorderMap);
//		root.right = helper(preIndex, inIndex+1, inEnd, preorder, inorder, inorderMap);
		
		return root;
	}

	private static Map<Integer, Integer> createMap(int[] inorder) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int in = 0;
		for (int i : inorder) {
			hm.put(i, in++);
		}
		return hm;
	}
	
	private static Map<Integer, Integer> createMap2(int[] inorder) {
		AtomicInteger index = new AtomicInteger(0);
		
		Map<Integer, Integer> map = Arrays.stream(inorder)
											.boxed()
											.collect(Collectors.toMap(i -> i, v -> index.getAndIncrement()));
		return map;
	}

	static void traverseLevelOrder(Node root) {
		if (root == null)	return;
		
		Queue<Node> queue = new LinkedList<Node>();
		Node current;
		int levelSize = 0;
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			levelSize = queue.size();					
			
			int i = 0;
			while (i < levelSize) {		
				current = queue.poll();

				System.out.print(current.val + " ");
				if (current.left != null)	queue.offer(current.left);
				if (current.right != null)	queue.offer(current.right);
				i++;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		Node root = buildTree(preorder, inorder);
		traverseLevelOrder(root);
	}
}
