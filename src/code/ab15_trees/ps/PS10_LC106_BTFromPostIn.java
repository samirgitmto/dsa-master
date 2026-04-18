package code.ab15_trees.ps;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Construction of Binary Tree using Inorder and Postorder traversals arrays
 * 
 * @since 23-11-2-25
 */
public class PS10_LC106_BTFromPostIn {

	static int postIndex = 0;
	
	static TreeNode buildTree(int[] inorder, int[] postorder) {
        
		Map<Integer, Integer> inMap = IntStream.range(0, inorder.length)
												.boxed()
												.collect(Collectors.toMap(i -> inorder[i], i -> i));
		
		postIndex = postorder.length - 1;
		int inStart=0, inEnd=inorder.length-1;
		return helper(inStart, inEnd, inorder, postorder, inMap);
    }
	
	private static TreeNode helper(int inStart, int inEnd, int[] inorder, int[] postorder, Map<Integer, Integer> inMap) {
		if (inStart > inEnd)	return null;
		
		int rootValue = postorder[postIndex];
		postIndex--;
		
		TreeNode root = new TreeNode(rootValue);
		
		int inIndex = inMap.get(rootValue);
		
		root.right = helper(inIndex+1, inEnd, inorder, postorder, inMap);
		root.left = helper(inStart, inIndex-1, inorder, postorder, inMap);
		
		return root;
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
		int[] postOrder = {2, 1, 5, 4, 3};
		int[] inorder = {1, 2, 3, 4, 5};
		TreeNode root = buildTree(inorder, postOrder);
		traverseLevelOrder(root);
	}	
	
}
