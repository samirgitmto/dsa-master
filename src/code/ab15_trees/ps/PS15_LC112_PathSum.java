package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Leetcode 112
 * 
 * @since 23-11-2025
 */
public class PS15_LC112_PathSum {

	static boolean hasPathSumBFS(TreeNode root, int targetSum) {
		if (root == null)	return false;
		
		Queue<NodeWrapper> queue = new ArrayDeque<>();
		queue.offer(new NodeWrapper(root, root.val));
		
		while (!queue.isEmpty()) {
			NodeWrapper current = queue.poll();
			TreeNode nextLeft = current.node.left;
			TreeNode nextRight = current.node.right;
			if (nextLeft == null
					&& nextRight == null
					&& current.currentSum == targetSum) {
				return true;
			}
			
			if (nextLeft != null) {
				NodeWrapper left = new NodeWrapper(nextLeft, current.currentSum + nextLeft.val);
				queue.offer(left);
			}
			if (nextRight != null) {
				NodeWrapper right = new NodeWrapper(nextRight, current.currentSum + nextRight.val);
				queue.offer(right);
			}
		}
		
		return false;
	}
	
	/**
	 * @since 10-05-2026
	 * @param root
	 * @param targetSum
	 * @return
	 */
	static boolean hasPathSumDFS(TreeNode root, int targetSum) {
		if (root == null)	return false;
		
		if (root.left == null && root.right == null)
			return targetSum == 0;
		
		boolean hasPathSumLeft = hasPathSumDFS(root.left, targetSum-root.val);
		
		if (hasPathSumLeft)
			return true;
		
		return hasPathSumDFS(root.right, targetSum-root.val);
	}
	
	static List<List<Integer>> hasPathSumIIDFS(TreeNode root, int targetSum) {
		if (root == null)	return Collections.EMPTY_LIST;
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(root, targetSum, res, new ArrayList<Integer>());
		return res;
	}
	
	/**
	 * Main Invariant: At every recursive call, current contains the exact root-to-current-node path.
	 * Time: O(n²); Space: O(h)
	 * @param root
	 * @param targetSum
	 * @param finalList
	 * @param current
	 */
	private static void dfs(TreeNode root, int targetSum, List<List<Integer>> finalList,
			List<Integer> current) {
		if (root == null)	return;
		
		current.add(root.val);
		
		if (root.left == null && root.right == null) {
			if (targetSum == root.val) {
				finalList.add(new ArrayList<Integer>(current));
			}
//			return;
		}
		else {
			dfs(root.left, targetSum - root.val, finalList, current);
			dfs(root.right, targetSum - root.val, finalList, current);
		}
		
		current.removeLast();
	}
	
	private static void dfs0(TreeNode root, int targetSum, List<List<Integer>> finalList,
			List<Integer> current) {
		if (root == null)	return;
		
		if (root.left == null && root.right == null) {
			if (targetSum == root.val) {
				current.add(root.val);
				finalList.add(new ArrayList<Integer>(current));
			}
			return;
		}
		
		current.add(root.val);
		dfs(root.left, targetSum - root.val, finalList, current);
		
		current.removeLast();
		dfs(root.right, targetSum - root.val, finalList, current);
	}

	public static void main(String[] args) {
		
	}
}
class NodeWrapper {
	TreeNode node;
	int currentSum;
	public NodeWrapper(TreeNode node, int x) {
		this.node = node;
		this.currentSum = x;
	}
}