package code.ab15_trees.ps;

/**
 * You are given the root of a binary tree.
 * We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children. 
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 * 
 * @since 24-11-2025
 */
public class PS17_LC968_BTCamerasH {

	static int NOT_COVERED = 0;
	static int HAS_CAMERA = 1;
	static int COVERED = 2;
	
	static int cameras = 0;
	
	static int minCameraCover(Node root) {
        if (root == null) return 0;
        
        cameras = 0;
        
        if (dfs(root) == NOT_COVERED)
        	cameras++;
        
        return cameras;
    }
	
	private static int dfs(Node root) {
		if (root == null)
			return COVERED;
		
		int left = dfs(root.left);
		int right = dfs(root.right);
		
		if (left == NOT_COVERED || right == NOT_COVERED) {
			cameras++;
			return HAS_CAMERA;
		}
		
		if (left == HAS_CAMERA || right == HAS_CAMERA) {
			return COVERED;
		}
		
		return NOT_COVERED;
	}

	public static void main(String[] args) {
		Node node = new Node(10);
		node.left = new Node(20);
		node.right = new Node(30);
		System.out.println(minCameraCover(node));
		
		node.left.left = new Node(40);
		node.left.right = new Node(50);
		System.out.println(minCameraCover(node));
	}
}