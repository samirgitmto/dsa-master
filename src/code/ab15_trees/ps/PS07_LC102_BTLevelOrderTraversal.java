package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Use a queue for BFS.
 * Push the root.
 * While queue not empty:
 *  Determine level size (number of nodes in this level).
 *  Pop exactly those many nodes:
 *   Add their values to the current level list.
 *   Push their left and right children into queue.
 * Add each level list to the final result.
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */
public class PS07_LC102_BTLevelOrderTraversal {

	// can be improved by preventing null insertion in queue
	static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)	return null;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
//        int level = 0;
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        while (!queue.isEmpty()) {
        	int levelSize = queue.size();
        	List<Integer> levelNodes = new ArrayList<Integer>();
        	int i = 0;
        	while (i < levelSize) {
        		TreeNode polled = queue.poll();
        		if (polled != null) {
        			queue.offer(polled.left);
        			queue.offer(polled.right);
        			levelNodes.add(polled.val);
        		}
        		i++;
        	}
        	if (!levelNodes.isEmpty()) {
        		res.add(levelNodes);
        	}
        	
        }
        
        return res;
	}
	
	// not efficient
	static List<List<Integer>> levelOrderV1(TreeNode root) {
        if (root == null)	return null;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
//        int level = 0;
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();        
        while (!queue.isEmpty()) {
        	List<Integer> levelNodes = new ArrayList<Integer>();
        	Queue<TreeNode> nextLevelQueue = new LinkedList<TreeNode>();
        	int levelSize = queue.size();
        	int i = 0;
        	while (i<levelSize) {
        		TreeNode polled = queue.poll();
        		if (polled != null) {
        			levelNodes.add(polled.val);
        			nextLevelQueue.offer(polled.left);
        			nextLevelQueue.offer(polled.right);
        		}
        		i++;
        	}
        	if (!levelNodes.isEmpty())
        		res.add(levelNodes);
        	queue = nextLevelQueue;
        }
        
		return res;
    }
	
	static void levelOrderTraversal(TreeNode root) {
		if (root == null)	return;
		
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			System.out.print(current.val + " ");
			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}
		System.out.println();
	}
	static void levelOrderTraversalV1(TreeNode root) {
		if (root == null)	return;
		
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		System.out.print(root.val + " ");
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (root.left != null) {
				System.out.print(root.left.val + " ");
				queue.offer(root.left);
			}
			if (root.right != null) {
				System.out.print(root.right.val + " ");
				queue.offer(root.right);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		List<List<Integer>> levelOrder = levelOrder(root);
		for (List<Integer> list : levelOrder) {
			System.out.println(list);
		}
		
		levelOrderTraversal(root);
		levelOrderTraversal(root);
	}
	
}
