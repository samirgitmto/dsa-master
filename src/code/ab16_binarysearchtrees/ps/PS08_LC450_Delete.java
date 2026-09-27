package code.ab16_binarysearchtrees.ps;

/**
 * @since 14-05-2026
 */
public class PS08_LC450_Delete {

	/**
	 * Time & Space Complexity- O(log n)
	 * @param root
	 * @param key
	 * @return
	 */
	static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)	return null;
        if (isLeafNode(root)) {
        	if (root.val == key)	return null;
        }
        
        if (key < root.val) {
        	root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
        	root.right = deleteNode(root.right, key);
        }
        else {
        	if (height(root.left) > height(root.right)) {
        		TreeNode inPred = inOrderPredecessor(root.left);
        		root.val = inPred.val;
        		root.left = deleteNode(root.left, inPred.val);
        	}
        	else {
        		TreeNode inOrderSuccessor = inOrderSuccessor(root.right);
        		root.val = inOrderSuccessor.val;
        		root.right = deleteNode(root.right, inOrderSuccessor.val);
        	}
        }
        
        return root;
    }

	private static TreeNode inOrderPredecessor(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}
	private static TreeNode inOrderSuccessor(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	private static int height(TreeNode root) {
		if (root == null)	return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	private static boolean isLeafNode(TreeNode root) {
		return root.left == null && root.right == null;
	}
	
	private static void inOrderTraverse(TreeNode root) {
		if (root != null) {
			inOrderTraverse(root.left);
			System.out.print(root.val + " ");
			inOrderTraverse(root.right);
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		inOrderTraverse(root);
		System.out.println();
		deleteNode(root, 3);
		inOrderTraverse(root);
	}
}
