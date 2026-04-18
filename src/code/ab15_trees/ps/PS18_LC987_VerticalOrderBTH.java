package code.ab15_trees.ps;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 
 * @since 24-11-2025
 */
public class PS18_LC987_VerticalOrderBTH {

	static List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if (root == null) {
			return res;
		}
		
		Queue<Wrapper> queue = new ArrayDeque<Wrapper>();
		
//		Map<Integer, List<Wrapper>> map = new HashMap<>();
		Map<Integer, List<Wrapper>> map = new TreeMap<>();
//		Map<Integer, List<Wrapper>> map = new LinkedHashMap<>();
		
		Wrapper current = new Wrapper(root, 0, 0);
		queue.offer(current);
		
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println("processing node: " + current.node.val);
//			map.computeIfAbsent(current.y, ArrayList::new).add(current);
//			java.lang.IllegalArgumentException: Illegal Capacity: -1
			// note it
			map.computeIfAbsent(current.y, k -> new ArrayList<Wrapper>()).add(current);
			
			int currentX = current.x;
			int currentY = current.y;
			
			TreeNode leftNode = current.node.left;
			TreeNode rightNode = current.node.right;

			
			if (leftNode != null) {
				Wrapper leftWrapper = new Wrapper(leftNode, currentX+1, currentY-1);
				queue.offer(leftWrapper);
			}
			if (rightNode != null) {
				Wrapper rightWrapper = new Wrapper(rightNode, currentX+1, currentY+1);
				queue.offer(rightWrapper);
			}
		}
		
		
		System.err.println(map);
		
		
		
		for (Map.Entry<Integer, List<Wrapper>> entry : map.entrySet()) {
//			int key = entry.getKey();
			List<Wrapper> list = entry.getValue();
			if (list.size() > 1) {
				
//				List<Wrapper> nodeSortedList = list.stream().sorted((a, b) -> a.node.val - b.node.val).collect(Collectors.toList());
//				List<Wrapper> rowSortedList = nodeSortedList.stream().sorted((a, b) -> a.x - b.x).collect(Collectors.toList());
				
				
				// or
				List<Wrapper> rowSortedList =
					    list.stream()
					        .sorted(Comparator.comparingInt((Wrapper w) -> w.x)
					                          .thenComparingInt(w -> w.node.val))
					        .collect(Collectors.toList());
				
				
				List<Integer> nodeValList = rowSortedList.stream().map(w -> w.node.val).toList();
				res.add(nodeValList);
			}
			else {
				res.add(List.of(list.get(0).node.val));
			}
		}
		
		return res;
    }
	
	public static void main(String[] args) {
//		[3,9,20,null,null,15,7]
//		Node root = new Node(3);
//		root.left = new Node(9);
//		root.right = new Node(20);
//		root.right.left = new Node(15);
//		root.right.right = new Node(7);
//		
////		[[9],[3,15],[20],[7]]
//		System.out.println(verticalTraversal(root));
		
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		root2.right.left = new TreeNode(6);
		root2.right.right = new TreeNode(7);
		
		System.out.println(verticalTraversal(root2));
	}
	
}

class Wrapper {
	TreeNode node;
	int x;
	int y;
	public Wrapper(TreeNode node, int x, int y) {
		this.node = node;
		this.x = x;
		this.y = y;
	}
}