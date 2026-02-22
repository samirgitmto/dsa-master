package code.ab16_binarysearchtrees.ps;

import code.ab16_binarysearchtrees.ps.PS01_LC783_MinDiffBST.TreeNode;

/**
 * 
 * @since 04-12-2025
 */
public class PS06_LC99_RecoverBinarySearchTree {

	static TreeNode prev = null;
	static TreeNode first = null, second = null;
	public void recoverTree(TreeNode root) {
		prev = new TreeNode(Integer.MIN_VALUE);
		first = null; second = null;
		inorderDfs(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
		
	}
	
	private void inorderDfs(TreeNode root) {
		if (root == null)	return;
		
		inorderDfs(root.left);
		
		TreeNode current = root;
		if (prev.val > current.val) {
			if (first == null) {
				first = prev;
				second = current;
			}
			else {
				second = current;
			}
		}
		prev = current;
		inorderDfs(root.right);
	}

	public static void main(String[] args) {
		
	}
}