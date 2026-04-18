package code.ab15_trees.ps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Max level sum:
 * 1. BFS approach using Queue
 * 2. DFS approach with maintaining a list/array of level sums
 * 
 * @since 23-11-2022
 */
public class PS11_LC1161_MaxLevelSum {

	/**
	 * DFS approach (preorder)
	 * 
	 * @param root
	 * @return maxLevel
	 */
    static int maxLevelSum(TreeNode root) {
    	
    	List<Integer> levelSums = new ArrayList<Integer>();
    	
    	dfs(root, 1, levelSums);
    	
    	System.out.println(levelSums);
    	
    	int maxLevelSum = Collections.max(levelSums);
    	int maxLevelIndex = levelSums.indexOf(maxLevelSum) + 1;
    	return maxLevelIndex;
    }
	private int getMaxLevelIndexUsingStream(List<Integer> levelSums) {
		
		Integer maxLevelIndex = IntStream.range(0, levelSums.size())
							.boxed()
							.max(Comparator.comparing(levelSums::get))
							.orElse(-2);
		maxLevelIndex += 1; // 1 - based index
		return maxLevelIndex;
	}
	private static void dfs(TreeNode node, int currentLevel, List<Integer> levelSumList) {
		if (node == null)	return;
		
		if (currentLevel > levelSumList.size()) {
			levelSumList.add(node.val);
		}
		else {
			int existing = levelSumList.get(currentLevel - 1);
			levelSumList.set(currentLevel-1, existing + node.val);
		}
		
		dfs(node.left, currentLevel + 1, levelSumList);
		dfs(node.right, currentLevel + 1, levelSumList);
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		System.out.println(maxLevelSum(root));
	}
}