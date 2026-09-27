package code.ab16_binarysearchtrees.ps;

import java.util.Stack;

/**
 * 
 * @since 14-05-2026
 */
public class PS09_LC1008_BSTFromPreorder {

	/**
	 * Ancestors whose right subtree is not constructed yet will stored in Stack
	 * Time & Space - O(n) & O(log n) to O(n) for skewed tree
	 * @since 14-05-2026
	 */
	static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null)	return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode ptr = root;
        
        for (int i = 1; i < preorder.length; i++) {
        	if (preorder[i] < ptr.val) {
        		ptr.left = new TreeNode(preorder[i]);
        		stack.push(ptr);
        		ptr = ptr.left;
        	}
        	else {
        		if (stack.isEmpty() || preorder[i] < stack.peek().val) {
        			ptr.right = new TreeNode(preorder[i]);
        			ptr = ptr.right;
        		}
        		else {
        			ptr = stack.pop();
        			i--;
        		}
        	}
        }
        
        return root;
    }
	
	
	static void inTraverse(TreeNode root) {
		if (root != null) {
			inTraverse(root.left);
			System.out.print(root.val + " ");
			inTraverse(root.right);
		}
	}
	
	public static void main(String[] args) {
		int[] preorderArr = {30, 20, 10, 15, 25, 40, 50, 45};
		TreeNode bstFromPreorder = bstFromPreorder(preorderArr);
		inTraverse(bstFromPreorder);
	}
}
