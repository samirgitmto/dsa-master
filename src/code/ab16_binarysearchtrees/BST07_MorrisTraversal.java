package code.ab16_binarysearchtrees;


/**
 * @author Mohammad Samir
 * 
 * @since 13-10-2026
 */
public class BST07_MorrisTraversal {

	static void inorderMorrisTraversal(TreeNode root) {
		if (root == null)	return;
		TreeNode current = root;
		
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.val + " ");
				current = current.right;
			}
			else {
				TreeNode inorderPredecessor = getInorderPredecessor(current);
				if (inorderPredecessor.right == null) {
					inorderPredecessor.right = current;
					current = current.left;
				}
				else {
					inorderPredecessor.right = null;
					System.out.print(current.val + " ");
					current = current.right;
				}
			}
		}
		System.out.println();
	}
	
	static void preorderMorrisTraversal(TreeNode root) {
		if (root == null)	return;
		TreeNode current = root;
		
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.val + " ");
				current = current.right;
			}
			else {
				TreeNode inorderPredecessor = getInorderPredecessor(current);
				if (inorderPredecessor.right == null) {
					inorderPredecessor.right = current;
					System.out.print(current.val + " ");
					current = current.left;
				}
				else {
					inorderPredecessor.right = null;
					current = current.right;
				}
			}
		}
		System.out.println();
	}
	
 	private static TreeNode getInorderPredecessor(TreeNode current) {
 		TreeNode pred = current.left;
 		while (pred.right != current && pred.right != null) {
 			pred = pred.right;
 		}
 		
 		return pred;
 	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(20);
		root.right = new TreeNode(40);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(25);
		root.right.left = new TreeNode(35);
		root.right.right = new TreeNode(50);
		
		inorderMorrisTraversal(root);
		preorderMorrisTraversal(root);
	}
}
