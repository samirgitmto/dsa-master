package code.ab15_trees.ps;

/**
 * Max Depth using both BFS & DFS
 * 
 * @since 23-11-2-25
 */
public class PS12_LC104MaxDepthBT {

	static int maxDepthBFS(Node node) {
		
		return 0;
	}
	
	static int maxDepthDFS(Node node) {
		if (node == null)	return 0;
		
		return 1 + Math.max(maxDepthDFS(node.left), maxDepthDFS(node.right));
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(4);
		root.right = new Node(5);		
		root.left.left = new Node(2);
		root.left.right = new Node(3);
		root.left.right.left = new Node(7);
		System.out.println(maxDepthDFS(root));
	}
}
