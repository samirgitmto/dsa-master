package code.ab16_binarysearchtrees;

public class BST06_LC230_KthSmallest {

	static int current = 0;
//	static int current = 1;
	
	static int findKthSmallest(Node root, int k) {
		if (root == null)	return -1;
		current = 0;
		return dfsHelper(root, k);
	}
	
	private static int dfsHelper(Node root, int k) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Wrong approach
	 * Did not capture recursive returns
	 * Overwrote answer locally
	 * Returned meaningless values
	 * Didn’t plan return flow
	 * @param root
	 * @param k
	 * @return
	 */
	private static int dfsHelperW2(Node root, int k) {
		if (root == null || current >= k)
			return -1;
		
		int answer = -10;
		
		dfsHelper(root.left, k);
		
		current++;
		if (current == k) {
			answer = root.val;
			return answer;
		}
		
		dfsHelper(root.right, k);
		
		return answer;
	}

	/**
	 * Wrong approach
	 * Did not capture recursive returns
	 * Overwrote answer locally
	 * Returned meaningless values
	 * Didn’t plan return flow
	 * @param root
	 * @param k
	 * @return
	 */
	private static int dfsHelperW1(Node root, int k) {
		if (root == null)	return -1;
		
		if (current == k) {
			return root.val;
		}
		
		dfsHelper(root.left, k);
		current++;
		System.err.println("current: " + current);
		int kthSmallest = root.val;
		System.out.println("kthSmallest: " + kthSmallest);
		if (current == k)	return kthSmallest;
		dfsHelper(root.right, k);
		
		return kthSmallest;
	}

	public static void main(String[] args) {
		int [] preorder = {40, 30, 20, 35, 80, 70, 90};
		Node bsTfromPreorder = BST05_BSTfromPreOrder.createBSTfromPreorder(preorder);
		BST05_BSTfromPreOrder.traverse(bsTfromPreorder);
		System.out.println();
		System.out.println(findKthSmallest(bsTfromPreorder, 1));
		System.out.println(findKthSmallest(bsTfromPreorder, 3));
	}
}