package code.ab16_binarysearchtrees.ps;

public class PS01_LC783_MinDiffBST {

	static int min = Integer.MAX_VALUE;
	static Integer prev = null;
	
	static int minDiff(TreeNode root) {
		prev = null;
		min = Integer.MAX_VALUE;
		detMinDiffInOrder(root);
		return min;
	}
	
	private static void detMinDiffInOrder(TreeNode root) {
		if (root == null)	return;
		
		detMinDiffInOrder(root.left);
		
		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		
		prev = root.val;
		
		detMinDiffInOrder(root.right);
	}

	static int minDiff0(TreeNode root) {
		min = Integer.MAX_VALUE;
		detMinDiff(root, -1);
		return min;
	}
	
	// not efficient as it compares only with the parent node
	// using inorder traversal is is logical but not always the parent node will give the result
	// A global prev value is required which stores previously visited node in inorder.
	// [90,69,null,49,89,null,52]
	private static int detMinDiff(TreeNode root, int prevVal) {
		if (root == null) return -1;
		
		detMinDiff(root.left, root.val);
		min = Math.min(min, Math.abs((root.val - prevVal)));
		detMinDiff(root.right, root.val);
		
		return 0;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(6);
		System.out.println(minDiff(root));
		
		TreeNode root2 = new TreeNode(10);
		root2.left = new TreeNode(5);
		root2.right = new TreeNode(15);
		root2.right.left = new TreeNode(13);
		System.out.println(minDiff(root2));
	}
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int x) {
			this.val = x;
		}
	}
}