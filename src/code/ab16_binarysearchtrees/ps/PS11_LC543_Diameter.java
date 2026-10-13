package code.ab16_binarysearchtrees.ps;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root. 
 * The length of a path between two nodes is represented by the number of edges between them.
 * 
 * @since 13-10-2026
 */
public class PS11_LC543_Diameter {

	static int maxDia = 0;
	static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)	return 0;
        
		maxDia = 0;
		dfs(root);
		
		return maxDia;
    }
	
	private static int dfs(TreeNode root) {
		if (root == null)	return 0;
		
		int left = dfs(root.left);
		int right = dfs(root.right);
		
		int currentLength = left + right;
		if (currentLength > maxDia)	maxDia = currentLength;
		
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(2);
		int diameterOfBinaryTree = diameterOfBinaryTree(root);
		System.out.println(diameterOfBinaryTree);
	}
}
