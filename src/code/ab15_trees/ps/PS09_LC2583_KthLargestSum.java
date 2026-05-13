package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @since 2025-11-22
 */
public class PS09_LC2583_KthLargestSum {

	/**
	 * BETTER to use min heap instead
	 * @param root
	 * @param k
	 * @return
	 */
	static long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null)	return -1;
        
        List<Long> listOfLevelsSum = new ArrayList<Long>();
        
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			long levelSum = 0;
			
			for (int i=0; i<levelSize; i++) {
				TreeNode current = queue.poll();
				levelSum += current.val;
				
				if (current.left != null)
					queue.offer(current.left);
				if (current.right != null)
					queue.offer(current.right);
			}
			
			listOfLevelsSum.add(levelSum);
		}
		
//		listOfLevelsSum.stream().mapToLong(Integer::longValue).sorted(Comparator.reverseOrder()).skip(k).max().get()
//		The method sorted() in the type LongStream is not applicable for the arguments (Comparator.reverseOrder())
		
		// convert LongStream → Stream<Long>
		Long result = listOfLevelsSum.stream()
				.sorted(Comparator.reverseOrder())
				.skip(k-1)
				.findFirst()
				.orElse(-1l);
		
		return result;
    
	}
	
	static long kthLargestLevelSumV1(TreeNode root, int k) {
        if (root == null)	return -1;
        
        List<Long> listOfLevelsSum = new ArrayList<Long>();
        
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			long levelSum = 0;
			
			for (int i=0; i<levelSize; i++) {
				TreeNode current = queue.poll();
				levelSum += current.val;
				
				if (current.left != null)
					queue.offer(current.left);
				if (current.right != null)
					queue.offer(current.right);
			}
			
			listOfLevelsSum.add(levelSum);
		}
		
//		listOfLevelsSum.stream().mapToLong(Integer::longValue).sorted(Comparator.reverseOrder()).skip(k).max().get()
//		The method sorted() in the type LongStream is not applicable for the arguments (Comparator.reverseOrder())
		
		// convert LongStream → Stream<Long>
		Long result = listOfLevelsSum.stream()
				.mapToLong(Long::intValue)
				.boxed()
				.sorted(Comparator.reverseOrder())
				.skip(k-1)
				.findFirst()
				.orElse(-1l);
		
		return result;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println(kthLargestLevelSum(root, 2));
		System.out.println(kthLargestLevelSum(root, 1));
	}
}

class Solution5 {
	
    public long kthLargestLevelSum(TreeNode root, int k) {
    	if (root == null)	return -1;
    	PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
    	
    	Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		int levelSize = queue.size();
    		long levelSum = 0;
    		for (int i = 0; i < levelSize; i++) {
    			TreeNode node = queue.poll();
    			levelSum += node.val;
    			
    			if (node.left != null)	queue.offer(node.left);
    			if (node.right != null)	queue.offer(node.right);
    		}
    		minHeap.offer(levelSum);
    		while (minHeap.size() > k) {
    			minHeap.poll();
    		}
    	}
    	
    	return minHeap.size() == k ? minHeap.peek() : -1;
    }

	private long getKthLargest(List<Long> list, int k) {
		Long res = list.stream().sorted(Comparator.reverseOrder()).skip(k-1).findFirst().orElse(-1l);
		return res;
	}
}