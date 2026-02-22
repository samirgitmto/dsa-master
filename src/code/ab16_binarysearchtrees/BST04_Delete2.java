package code.ab16_binarysearchtrees;

public class BST04_Delete2 {

	static Node delete(Node root, int key) {
		if (root == null)	return null;
		
		if (key < root.val)
			root.left = delete(root.left, key);
		else if (key > root.val)
			root.right = delete(root.right, key);
		else {
			// Case 1 - leaf
			if (root.left == null && root.right == null)
				return null;
			
			// Case 2 - single child
			if (root.left == null)	return root.right;
			if (root.right == null)	return root.left;
			
			// Case 3 - 2 children
			if (height(root.left) > height(root.right)) {
				Node inOrderPredecessor = inOrderPredecessor(root.left);
				root.val = inOrderPredecessor.val;
				root.left = delete(root.left, inOrderPredecessor.val);
			}
			else {
				Node inOrderSuccessor = inOrderSuccessor(root.right);
				root.val = inOrderSuccessor.val;
				root.right = delete(root.right, inOrderSuccessor.val);
			}
		}
		return root;
	}
	
	private static Node inOrderSuccessor(Node right) {
		while (right != null && right.left != null) {
			right = right.left;
		}
		return right;
	}

	private static Node inOrderPredecessor(Node left) {
		while (left != null && left.right != null) {
			left = left.right;
		}
		return left;
	}

	private static int height(Node root) {
		if (root == null)	return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	static Node createBSTfromArr(int[] arr) {
		if (arr == null)	return null;
		Node root = null;
		for (int in : arr) {
			root = insertRec(root, in);
		}
		return root;
	}
	
	private static Node insertRec(Node root, int in) {
		if (root == null) {
			return new Node(in);
		}
		if (root.val > in) {
			root.left = insertRec(root.left, in);
		}
		else if (root.val < in) {
			root.right = insertRec(root.right, in);
		}	
		return root;
	}

	static void traverseInOrder(Node root) {
		if (root != null) {
			traverseInOrder(root.left);
			System.out.print(root.val + " ");
			traverseInOrder(root.right);
		}
	}
	public static void main(String[] args) {
//		int[] arr = {1, 5, 15, 10, 20, 25};
//		int[] arr = {10, 20};
		int[] arr = {10, 5};
		Node bsTfromArr = createBSTfromArr(arr);
		traverseInOrder(bsTfromArr);
		System.out.println();
		
		Node delete = delete(bsTfromArr, 10);
		traverseInOrder(delete);
		System.out.println();
		traverseInOrder(bsTfromArr);
		System.out.println();
	}
}