package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @since 29-11-2025
 */
public class PS20_LC993_Cousins {

	/**
	 * BFS
	 * Complexity: Time		Space
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	static boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)	return false;
		
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
				
		TreeNode parentX = null;
		TreeNode parentY = null;
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			
			for (int i = 0; i < levelSize; i++) {
				TreeNode current = queue.poll();
				
				if (current.left != null) {
					if (current.left.val == x)	parentX = current;
					if (current.left.val == y)	parentY = current;
					queue.offer(current.left);
				}
				if (current.right != null) {
					if (current.right.val == x) parentX = current;
					if (current.right.val == y)	parentY = current;
					queue.offer(current.right);
				}
			}
			
			if (parentX != null ^ parentY != null) {
				return false;
			}
			if (parentX != null && parentY != null) {
				return parentX != parentY;
			}
			
			parentX = null;
			parentY = null;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(5);
		
		System.out.println(isCousins(root, 2, 3));
		System.out.println(isCousins(root, 4, 5));
	}
}

/**
 * 
 * @since 13-05-2026e
 */
class Solution8 {
	
	/**
	 * Leetcode 100
	 * @param p
	 * @param q
	 * @return
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == q) && p == null)	return true;
        if (p == null ^ q == null)	return false;
        
        return dfs(p, q);
    }

	private boolean dfs(TreeNode p, TreeNode q) {
		if ((p == q) && p == null)	return true;
        if (p == null ^ q == null)	return false;
		
        if (p.val != q.val)	return false;
        
		return dfs(p.left, q.left) && dfs(p.right, q.right);
	}
	
	/**
	 * Leetcode 993
	 * BFS
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)	return false;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode parentX = null;
        TreeNode parentY = null;
        while (!queue.isEmpty() && (parentX == null && parentY == null)) {
        	int levelSize = queue.size();
        	
        	for (int i = 0; i < levelSize; i++) {
        		TreeNode poll = queue.poll();
        		
        		if (poll.left != null) {
        			if (poll.left.val == x)	parentX = poll;
        			if (poll.left.val == y)	parentY = poll;
        			queue.offer(poll.left);
        		}
        		if (poll.right != null) {
        			if (poll.right.val == x)	parentX = poll;
        			if (poll.right.val == y)	parentY = poll;
        			queue.offer(poll.right);
        		}
        	}
        }
        
        if (parentX == null ^ parentY == null)	return false;
        if (parentX == null && parentY == null)	return false;
        
        return parentX != parentY;
    }
}