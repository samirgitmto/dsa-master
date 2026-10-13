package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 * The maximum width of a tree is the maximum width among all levels.
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
 *  where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that 
 *  level are also counted into the length calculation.
 * It is guaranteed that the answer will in the range of a 32-bit signed integer.
 * @since 13-10-2026
 */
public class PS22_LC662_MaxDiameter {

	/**
	 * BFS approach using a Queue<Node, Index>
	 * @param root
	 * @return width
	 */
	static int widthOfBinaryTree(TreeNode root) {
        if (root == null)	return 0;
        
        Queue<Object[]> queue = new ArrayDeque<Object[]>();
        
        Long width = 1l;
        
        long index = 0;
        
        queue.offer(new Object[]{root, 0l});
        
        while (!queue.isEmpty()) {
        	int levelSize = queue.size();
        	
        	long first = (long) queue.peek()[1];
        	long last = first;
        	
        	for (int i = 0; i < levelSize; i++) {
				Object[] poll = queue.poll();
				TreeNode node = (TreeNode) poll[0];
				index = (long) poll[1];
				last = index;
				
				if (node.left != null) {
					queue.offer(new Object[] {node.left, 2 * index + 1});
				}
				if (node.right != null) {
					queue.offer(new Object[] {node.right, 2 * index + 2});
				}
			}
        	
        	width = Math.max(width, last - first + 1);
        }
        return width.intValue();
    }
	
	static Long width = 1l;
	static int widthOfBinaryTreev2(TreeNode root) {
		if (root == null)	return 0;
		
		width = 1l;
		List<Long> levelFirstIndex = new ArrayList<Long>();
		long currentIndex = 0;
		int level = 0;
		levelFirstIndex.add(0l);
		dfsPreorder(root, levelFirstIndex, currentIndex, level);
		
		return width.intValue();
	}
	
	private static void dfsPreorder(TreeNode root, List<Long> levelFirstIndex, long currentIndex, int level) {
		if (root == null)	return;
		
		if (levelFirstIndex.size() <= level) {
			levelFirstIndex.add(currentIndex);
		}
		
		width = Math.max(width, currentIndex - levelFirstIndex.get(level) + 1);
		
		dfsPreorder(root.left, levelFirstIndex, 2 * currentIndex + 1, level+1);
		dfsPreorder(root.right, levelFirstIndex, 2 * currentIndex + 2, level+1);
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(3);
		node.left.left = new TreeNode(5);
		node.right = new TreeNode(2);
		
		System.err.println(widthOfBinaryTreev2(node));
	}
}
