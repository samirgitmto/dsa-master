package code.ab15_trees.ps;


/**
 * @since 12-10-2026
 */
public class PS21_LC236_LCA {

	
	/**
	 * POST Order DFS
	 * O(n)
	 * O(h)
	 * @param root 
	 * @param p
	 * @param q
	 * @return
	 */
	static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)	return null;

        return dfsPostOrder(root, p, q);
    }
	
	
	private static TreeNode dfsPostOrder(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) 
			return root;
		System.err.println(root.val);
		TreeNode left = dfsPostOrder(root.left, p, q);
		TreeNode right = dfsPostOrder(root.right, p, q);
		
		if (left != null && right != null)
			return root;
		
		return left != null ? left : right;
	}


	public static void main(String[] args) {
		TreeNode head = new TreeNode(30);
		head.left = new TreeNode(20);
		head.right = new TreeNode(40);
		head.left.left = new TreeNode(10);
		head.left.right = new TreeNode(25);
		head.right.left = new TreeNode(35);
		head.right.right = new TreeNode(50);
		
		TreeNode lowestCommonAncestor0 = lowestCommonAncestor(head, head.left.left, head.right);
		System.out.println("result1: " + lowestCommonAncestor0.val);
		
		TreeNode lowestCommonAncestor = lowestCommonAncestor(head, head.left.left, head.left.right);
		System.out.println("result2: " + lowestCommonAncestor.val);
	}
	
}
