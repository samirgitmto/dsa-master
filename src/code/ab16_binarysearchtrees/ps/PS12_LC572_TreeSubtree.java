package code.ab16_binarysearchtrees.ps;

import java.util.Stack;

/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure
 *  and node values of subRoot and false otherwise. 
 *  A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 *   The tree tree could also be considered as a subtree of itself.
 * 
 * @since 13-10-2026
 */
public class PS12_LC572_TreeSubtree {

	static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)	return false;
        
        TreeNode search = search(root, subRoot.val);
        
        if (isIdentical(search, subRoot))	return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

	/*
	 * Not a complexity improvement
	 * searchAll()     → O(N)
	 * isIdentical()   → up to O(M) for each candidate 
	 *                 → O(K × M)
	 */
	static boolean isSubtreev2(TreeNode root, TreeNode subRoot) {
		if (root == null || subRoot == null)	return false;
		
		Stack<TreeNode> search = searchAll(root, subRoot.val, new Stack<TreeNode>());
		
		boolean identical = false;
		
		while (!search.isEmpty() && !identical) {
			identical = isIdentical(subRoot, search.pop());
		}
		
		return identical;
	}
	
	static TreeNode search(TreeNode root, int key) {
		if (root == null)	return null;
		else if (root.val == key)	return root;
		
		TreeNode left = search(root.left, key);
		
		if (left == null)
			return search(root.right, key);
		
		return left;
	}
	static Stack<TreeNode> searchAll(TreeNode root, int key, Stack<TreeNode> stack) {
		if (root == null)	return null;
		else if (root.val == key) {
			stack.push(root);
		}
		
		searchAll(root.left, key, stack);
		searchAll(root.right, key, stack);
		
		return stack;
	}
	
	static boolean isIdentical(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)	return true;
		else if (root1 == null ^ root2 == null)	return false;
		else if (root1.val != root2.val)	return false;
		
		return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		
		TreeNode subroot = new TreeNode(1);
		
		boolean subtree = isSubtree(root, subroot);
		System.err.println(subtree);
		boolean subtree2 = isSubtreev2(root, subroot);
		System.err.println(subtree2);
	}
}
