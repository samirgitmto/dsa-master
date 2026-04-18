package code.ab15_trees.ps;

/**
 * Max Depth using both BFS & DFS
 * 
 * @since 23-11-2-25
 */
public class PS12_LC104MaxDepthBT {

	static int maxDepthBFS(TreeNode node) {
		
		return 0;
	}
	
	static int maxDepthDFS(TreeNode node) {
		if (node == null)	return 0;
		
		return 1 + Math.max(maxDepthDFS(node.left), maxDepthDFS(node.right));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(7);
		System.out.println(maxDepthDFS(root));
	}
}
