package code.ab16_binarysearchtrees.ps;

import code.ab16_binarysearchtrees.ps.PS01_LC783_MinDiffBST.TreeNode;

public class PS07_LC669_TrimBinarySearchTree {

	public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)	return null;
        
		if (root.val < low) {
			return trimBST(root.right, low, high);
		}
		else if (root.val > high) {
			return trimBST(root.left, low, high);
		}
		else {
			root.left = trimBST(root.left, low, high);
			root.right = trimBST(root.right, low, high);
			return root;
		}
    }
	
	public static void main(String[] args) {
		
	}
}