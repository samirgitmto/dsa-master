package code.ab15_trees.ps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * construction of Binary Tree using Preorder and Inorder traversals arrays
 * @since 22-11-2025
 */
public class PS08_LC105_BTFromPrenIn {

	static int preIndex = 0;
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = createMap(inorder);
        
        preIndex = 0;  
        return helper(0, preorder.length-1, preorder, inorder, inorderMap);
    }
	
	private static TreeNode helper(int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap) {
		if (inStart > inEnd || preIndex > preorder.length-1)	return null;
		
		int rootValue = preorder[preIndex];
		preIndex++;
		
		TreeNode root = new TreeNode(rootValue);
		
		int inIndex = inorderMap.get(rootValue);
		
		root.left = helper(inStart, inIndex-1, preorder, inorder, inorderMap);
		root.right = helper(inIndex+1, inEnd, preorder, inorder, inorderMap);
		
		return root;
	}
	
	// have to investigate the preIndex passing problem here
	private static TreeNode helper0(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap) {
		if (inStart > inEnd || preIndex > preorder.length-1)	return null;
		
		int rootValue = preorder[preIndex];
		preIndex++;
		
		TreeNode root = new TreeNode(rootValue);
		
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

	static void traverseLevelOrder(TreeNode root) {
		if (root == null)	return;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode current;
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
		TreeNode root = buildTree(preorder, inorder);
		traverseLevelOrder(root);
	}
}

/**
 * @since 19-04-2026
 */
class Solution4 {
	
//    static int preIndex;
	
	/**
	 * Main Invariant: At every recursive call, preIndex points to the root of the subtree defined by the current inorder range,
	 *  and the inorder range fully represents that subtree.
	 *
	 * INVARIANT:
	 * 1. At the start of every recursive call:
	 *    - preIndex[0] points to the root of the current subtree.
	 *
	 * 2. The inorder range [inStart, inEnd]:
	 *    - Represents exactly all nodes belonging to this subtree.
	 *    - Left subtree  → [inStart, inIndex - 1]
	 *    - Right subtree → [inIndex + 1, inEnd]
	 *
	 * 3. Construction flow:
	 *    - Preorder gives root (preIndex moves forward).
	 *    - Inorder splits subtree into left and right parts.
	 *
	 * 4. Key guarantee:
	 *    - Left subtree is built first → consumes its nodes in preorder.
	 *    - preIndex naturally advances to the correct root of right subtree.
	 *
	 * 5. Termination:
	 *    - When inStart > inEnd → no nodes → return null.
	 * Summary: preIndex always points to the correct root for the current inorder-defined subtree.
	 *  
	 * Map reduces the Time Complexity from O(n2) to O(n).
	 * HashMap takes O(n), and recursion stack takes O(h), which is O(log n) for balanced and O(n) in worst case. So overall space is O(n).
	 * Space: O(n)
	 * - O(n) for HashMap
	 * - O(h) recursion stack (h = tree height)
	 *  
	 * @param preorder
	 * @param inorder
	 * @return root
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if (preorder == null || preorder.length == 0 || preorder.length != inorder.length)
    		return null;
    	
    	Map<Integer, Integer> inMap = createInorderMap(inorder);
    	
    	// Global preOrderPointer BUT violates Purity of the function.
    	// Thus we can pass it as parameter using an array
    	// Even this “pure” version is not fully pure in strict FP sense because: You still mutate preIndex[0]
    	int[] preIndex = {0}; // acts like a mutable pointer as Object references are passed by value
    	
    	int inStart = 0;
    	int inEnd = inorder.length - 1;
    	
        return helper(preorder, inStart, inEnd, inMap, preIndex);
    }

	private TreeNode helper(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> inMap, int[] preIndex) {
		if (inStart > inEnd)	return null;
		
		int localRootValue = preorder[preIndex[0]];
		preIndex[0]++;
		int inIndex = inMap.get(localRootValue);
		
		TreeNode root = new TreeNode(localRootValue);
		root.left = helper(preorder, inStart, inIndex-1, inMap, preIndex);
		root.right = helper(preorder, inIndex+1, inEnd, inMap, preIndex);
		return root;
	}

	private Map<Integer, Integer> createInorderMap(int[] inorder) {
//		Map<Integer, Integer> map = IntStream.range(0, inorder.length)
//			.boxed()
//			.collect(Collectors.toMap(i -> inorder[i], i -> i));
		
		// preferred
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(inorder.length, 1);
		int i = 0;
		for (int e : inorder) {
			map.put(e, i);
			i++;
		}
		
		return map;
	}
}