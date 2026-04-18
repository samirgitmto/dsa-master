package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PS16_LC113_PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if (root == null) return res;
		
		Queue<NodeWrapper> queue = new ArrayDeque<>();
		
		NodeWrapper e = new NodeWrapper(root, root.val);
		e.list = new ArrayList<>();
		e.list.add(root.val);
		queue.offer(e);
		
		while (!queue.isEmpty()) {
			NodeWrapper current = queue.poll();
			TreeNode nextLeft = current.node.left;
			TreeNode nextRight = current.node.right;
			if (nextLeft == null
					&& nextRight == null
					&& current.currentSum == targetSum) {
//				res.add(current.list);
				res.add(new ArrayList<Integer>(current.list));
			}
			
			if (nextLeft != null) {
				NodeWrapper left = new NodeWrapper(nextLeft, current.currentSum + nextLeft.val);
				left.list = new ArrayList<Integer>(current.list);
				left.list.add(nextLeft.val);
				queue.offer(left);
			}
			if (nextRight != null) {
				NodeWrapper right = new NodeWrapper(nextRight, current.currentSum + nextRight.val);
				right.list = new ArrayList<Integer>(current.list);
				right.list.add(nextRight.val);
				queue.offer(right);
			}
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		
	}
	
	static class NodeWrapper {
		TreeNode node;
		int currentSum;
		List<Integer> list;
		public NodeWrapper(TreeNode node, int x) {
			this.node = node;
			this.currentSum = x;
		}
	}
}
