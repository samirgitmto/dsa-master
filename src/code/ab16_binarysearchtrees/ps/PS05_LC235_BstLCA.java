package code.ab16_binarysearchtrees.ps;

import code.ab16_binarysearchtrees.ps.PS01_LC783_MinDiffBST.TreeNode;

/**
 * Optimized approach in case of BST
 * @since 04-12-2025
 */
public class PS05_LC235_BstLCA {
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode lowestCommonAncestor;
		if ((p.val < root.val) && (q.val < root.val)) {
        	lowestCommonAncestor = lowestCommonAncestor(root.left, p, q);
        }
        else if ((p.val > root.val) && (q.val > root.val)) {
        	lowestCommonAncestor = lowestCommonAncestor(root.right, p, q);
        }
        else
        	return root;
        return lowestCommonAncestor;
    }
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(7);
		node.left = new TreeNode(3);
		node.right= new TreeNode(15);
		node.left.right = new TreeNode(4);
		node.left.right.right = new TreeNode(5);
		
		System.out.println(lowestCommonAncestor(node, node.left, node.right).val);
	}
	
}