package code.ab15_trees.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @since 21-11-2025
 */
public class PS04_PreorderTraversal {

	static void iterativePreorder(TreeNode root) {
		if (root == null)	return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			root = stack.pop();
			
			System.out.print(root.val + " ");
			
			if (root.right != null)
				stack.push(root.right);
			if (root.left != null)
				stack.push(root.left);
		}
		System.out.println();
	}
	
	static void iterativePreorderV1(TreeNode root2) {
		if (root2 == null)	return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root2);
		TreeNode root = null;
		while (!stack.isEmpty()) {
			if (root == null) {
				root = stack.pop();
			}
			System.out.print(root.val + " ");
			if (root.right != null) {
				stack.push(root.right);
			}
			root = root.left;	// over complicated
		}
	}
	
	static void recPreorderTraversal(TreeNode root) {
		if (root != null) {
			System.out.print(root.val);
			recPreorderTraversal(root.left);
			recPreorderTraversal(root.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		iterativePreorder(root);
//		iterativePreorderV1(root);
//		recPreorderTraversal();
	}
}

class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int x) {
		this.val = x;
	}
}

/**
 * @since 18-04-2026
 */
class Solution {
	
	/**
	 * 
	 * Time: O(n)
	 * Space: O(h) (worst-case O(n))
	 * @param root
	 * @return
	 */
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if (root == null)	return list;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode pop = stack.pop();
        	list.add(pop.val);
        	
        	if (pop.right != null)	stack.push(pop.right);
        	if (pop.left != null)	stack.push(pop.left);
        }
        
        return list;
    }
}