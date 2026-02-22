package code.ab16_binarysearchtrees;

/**
 * 
 * @since 28-09-2025
 */
public class BST04_Delete {

	/**
	 * 
	 * @since 28-09-2025
	 * 
	 * @param root
	 * @param i
	 * @return
	 */
	private static Node delete(Node root, int i) {
		if (root==null) {
			return null;
		}
		Node inorderNeighbourNode = null;
		if (i<root.val) {
			root.left = delete(root.left, i);
		}
		else if (i>root.val) {
			root.right = delete(root.right, i);
		}
		else {
			if (root.left==null && root.right==null)
				return null;
			else {
				if (root.left!=null) {
					inorderNeighbourNode = inorderPredecessor(root.left);
					root.val = inorderNeighbourNode.val;
					root.left = delete(root.left, inorderNeighbourNode.val);
				}
				else {
					inorderNeighbourNode = inorderSuccessor(root.right);
					root.val = inorderNeighbourNode.val;
					root.right = delete(root.right, inorderNeighbourNode.val);
				}
			}
		}
		return root;
	}
	
	private static Node inorderSuccessor(Node rightNode) {
		while (rightNode!=null && rightNode.left!=null)
			rightNode = rightNode.left;
		return rightNode;
	}

	private static Node inorderPredecessor(Node leftNode) {
		while (leftNode!=null && leftNode.right!=null)
			leftNode = leftNode.right;
		return leftNode;
	}

	public static void main(String[] args) {
//		Node root = createBinarySearchTree(new int[]{10, 20, 40, 50, 60});
//		Node root = createBinarySearchTree(new int[]{10, 40, 20, 50, 60});
		Node root = createBinarySearchTree(new int[]{10, 20});
		inOrderTraverse(root);
		System.out.println();
		
		Node root2 = delete(root, 10);
		System.out.println("root");
		inOrderTraverse(root);
		System.out.println("\nroot2");
		inOrderTraverse(root2);
		System.out.println();
	}

	/**
	 * Complexity: Time O()
	 * 
	 * @param array of node elements values
	 * @return root of the constructed Binary Tree
	 */
	private static Node createBinarySearchTree(int[] is) {
		Node root = null;
		for (int i : is) {
			root = insertR(root, i);
		}
		
		return root;
	}

	private static Node insertR(Node root, int i) {
		if (root==null) {
			root = new Node(i);
			return root;
		}
		
		if (i<root.val)
			root.left = insertR(root.left, i);
		else if (i>root.val)
			root.right = insertR(root.right, i);
		
		return root;
	}
	
	private static void inOrderTraverse(Node root) {
		if (root==null)	{
			return;
		}
		inOrderTraverse(root.left);
		System.out.print(root.val + " ");
		inOrderTraverse(root.right);
	}
	
}