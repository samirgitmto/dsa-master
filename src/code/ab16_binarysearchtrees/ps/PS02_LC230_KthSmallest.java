package code.ab16_binarysearchtrees.ps;

import java.util.Stack;
/**
 * 
 * @since 04-12-2025
 */
public class PS02_LC230_KthSmallest {

	/**
	 * DFS approach. Not thread safe
	 * @param root
	 * @param k
	 * @return
	 */
	static int kthSmallest(TreeNode root, int k) {
		current = 0;
		return dfsInorder(root, k);
	}
	static int current = 0;
	private static int dfsInorder(TreeNode root, int k) {
		if (root == null || current >= k)
			return -1;
		
		int left = dfsInorder(root.left, k);
		if (left != -1)
			return left;
		
		current++;
		
		if (current == k)
			return root.val;
		
		return dfsInorder(root.right, k);
	}
	
	/**
	 * using Stack to simulate the in order recursion in iterative manner
	 * @param root
	 * @param k
	 * @return
	 */
	static int kthSmallestIter(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode current = root;
		
		while (true) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			if (stack.isEmpty())	break;
			current = stack.pop();
			k--;
			if (k==0)
				return current.val;
			
			current = current.right;
		}
		return -1;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(3);
		node.right= new TreeNode(6);
		node.left.left= new TreeNode(2);
		node.left.right= new TreeNode(4);
		node.left.left.left= new TreeNode(1);
		
		System.out.println(kthSmallest(node, 3));
		System.out.println(kthSmallest(node, 4));
		System.out.println(kthSmallest(node, 5));
		System.out.println(kthSmallestIter(node, 7));
		
		Solution2 solution2 = new Solution2();
		System.err.println(solution2.kthSmallest(node, 3));
	}
	
}

/**
 * @since 15-05-2026
 */
class Solution2 {
	// 1 -> 2
	static int i = 1;
	static int ans = -1;
	
	/**
	 * Time - O(h + k)
	 * Space - O(h)
	 * h for balanced -> O(log n)
	 * h for skewed -> O(n)
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
	    i = 1;
	    ans = -1;
	    dfs(root, k);
	    return ans;
	}
	private void dfs(TreeNode root, int k) {
		if (root != null) {
			dfs(root.left, k);
			if (i == k) {
				ans = root.val;
			}
			i++;
			if (i <= k)
				dfs(root.right, k);
		}
	}
}