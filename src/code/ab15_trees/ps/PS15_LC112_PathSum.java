package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 * @since 23-11-2025
 */
public class PS15_LC112_PathSum {

	static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)	return false;
		
		Queue<NodeWrapper> queue = new ArrayDeque<>();
		queue.offer(new NodeWrapper(root, root.val));
		
		while (!queue.isEmpty()) {
			NodeWrapper current = queue.poll();
			TreeNode nextLeft = current.node.left;
			TreeNode nextRight = current.node.right;
			if (nextLeft == null
					&& nextRight == null
					&& current.currentSum == targetSum) {
				return true;
			}
			
			if (nextLeft != null) {
				NodeWrapper left = new NodeWrapper(nextLeft, current.currentSum + nextLeft.val);
				queue.offer(left);
			}
			if (nextRight != null) {
				NodeWrapper right = new NodeWrapper(nextRight, current.currentSum + nextRight.val);
				queue.offer(right);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
	}
}
class NodeWrapper {
	TreeNode node;
	int currentSum;
	public NodeWrapper(TreeNode node, int x) {
		this.node = node;
		this.currentSum = x;
	}
}