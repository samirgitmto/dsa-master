package code.ab16_binarysearchtrees.ps;

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
//		
//		convertBST(node);
//		traverseInOrder(node);
		
		Solution3 solution3 = new Solution3();
		solution3.convertBST(node);
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

/**
 * @since 15-05-2026
 */
class Solution3 {
	static int runningSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null)	return null;
        runningSum = 0;
        return dfs(root);
    }
	private TreeNode dfs(TreeNode root) {
		if (root == null)
			return null;
		
		dfs(root.right);
		runningSum += root.val;
		
		root.val = runningSum;
		dfs(root.left);
		
		return root;
	}
}