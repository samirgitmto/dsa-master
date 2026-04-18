package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.HashMap;
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