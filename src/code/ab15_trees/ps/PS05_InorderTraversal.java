package code.ab15_trees.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @since 21-11-2023
 */
public class PS05_InorderTraversal {

	static void iterInorderTraverse(TreeNode root) {
		if (root == null)	return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			
			// accumulate left into stack
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			
			// pop and visit
			current = stack.pop();
			System.out.print(current.val + " ");
			
			// go right
			current = current.right;
		}
		System.out.println();
	}
	
	static void iterInorder(TreeNode root) {
		if (root == null)	return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				current = stack.pop();
				System.out.print(current.val + " ");
				current = current.right;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.right.right = new TreeNode(5);
		iterInorderTraverse(root);
		iterInorder(root);
		
		long prev1 = Integer.MIN_VALUE - 1;
//		long prev1 = Integer.MIN_VALUE - 1l;
		System.out.println(prev1);    // 2147483647
		long prev2 = Integer.MIN_VALUE;
		System.out.println(prev2);    // -2147483648

	}
	
}

/**
 * @since 18-04-2026
 */
class Solution2 {
	
	/**
	 * LC 94
	 * The stack stores the path to the current node. By pushing all left nodes 1st, we ensure that when we pop, we are visiting nodes in inorder sequence.
	 * @param root
	 * @return
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
    	
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
        	if (curr != null) {
        		stack.push(curr);
        		curr= curr.left;
        	}
        	else {
        		TreeNode node = stack.pop();
        		list.add(node.val);
        		curr = node.right;
        	}
        }
        
        return list;
    }
    
    /**
     * LC 98
     * Inorder traversal gives sorted order
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)	return true;
        
        long prev = Long.MIN_VALUE;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
        	while (curr != null) {
        		stack.push(curr);
        		curr = curr.left;
        	}
        	
        	// process
        	curr = stack.pop();
        	if (curr.val <= prev)	return false;
        	prev = curr.val;
        	// move to right
        	curr = curr.right;
        }
        
        return true;
    }
}