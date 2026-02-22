package code.ab16_binarysearchtrees.ps;

import code.ab16_binarysearchtrees.ps.PS01_LC783_MinDiffBST.TreeNode;

/**
 * 
 * @since 04-12-2025
 */
public class PS03_LC538_ConvertBSTtoGreaterTree {

	/**
	 * DFS
	 * @param root
	 * @return
	 */
    public static TreeNode convertBST(TreeNode root) {
    	if (root == null || (root.left == null && root.right == null))
    		return root;
    	sum = 0;
    	
    	dfsRev(root);
    	return root;
    }
    static int sum = 0;
	private static void dfsRev(TreeNode root) {
		if (root == null)
			return;
		
		dfsRev(root.right);
		
		root.val = root.val + sum;
		sum = root.val;
		
		dfsRev(root.left);
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(2);
		node.right= new TreeNode(5);
		node.right.left= new TreeNode(4);
		
//		node.left.right= new TreeNode(4);
//		node.left.left.left= new TreeNode(1);
		traverseInOrder(node);
		System.out.println();
		
		convertBST(node);
		traverseInOrder(node);
	}
	
	static void traverseInOrder(TreeNode root) {
		if (root != null) {
			traverseInOrder(root.left);
			System.out.print(root.val + " ");
			traverseInOrder(root.right);
		}
	}
}