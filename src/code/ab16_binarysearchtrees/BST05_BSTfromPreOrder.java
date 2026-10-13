package code.ab16_binarysearchtrees;

import java.util.Stack;

/**
 * 
 * @since 30-11-2025
 */
public class BST05_BSTfromPreOrder {
	
	static TreeNode bstFromPreorder(int[] arr) {
	    if (arr == null || arr.length == 0) return null;

	    
	    Stack<TreeNode> stack = new Stack<>();
	    TreeNode root = new TreeNode(arr[0]);
	    stack.push(root);

	    for (int i = 1; i < arr.length; i++) {
	        TreeNode node = new TreeNode(arr[i]);

	        // attach left
	        if (arr[i] < stack.peek().val) {
	            stack.peek().left = node;
	        }
	        else {
	            TreeNode parent = null;
	            // find parent for right
	            while (!stack.isEmpty() && arr[i] > stack.peek().val) {
	                parent = stack.pop();
	            }
	            parent.right = node;
	        }

	        stack.push(node);
	    }
	    return root;
	}

	/**
	 * Complexity: Time O(N)	Space O(H)
	 * @param arr
	 * @return
	 */
	static TreeNode createBSTfromPreorder(int[] arr) {
		if (arr == null)	return null;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode root = new TreeNode(arr[0]);
		TreeNode p = root;
		int i = 1;
		
		while (i < arr.length) {
			int current = arr[i];
			if (current < p.val) {
				p.left = new TreeNode(current);
				stack.push(p);
				p = p.left;
				i++;
			}
			else {
				if (stack.isEmpty() || current < stack.peek().val) {
					p.right = new TreeNode(current);
					p = p.right;
					i++;
				}
				else if (current > stack.peek().val) {
					p = stack.pop();
				}
			}
		}
		
		return root;
	}
	static void traverse(TreeNode root) {
		if (root != null) {
			traverse(root.left);
			System.out.print(root.val + " ");
			traverse(root.right);
		}
	}
	public static void main(String[] args) {
//		int[] arr = {40, 30, 35, 20};
//		int[] arr = {40, 30, 20, 35};
//		int[] arr = {40, 30, 20, 35, 80, 70, 90};
		int[] arr = {1, 3};
		TreeNode root = createBSTfromPreorder(arr);
//		Node root = bstFromPreorder(arr);
//		Node root = bstFromPreorderRec(arr);
		traverse(root);
	}
}