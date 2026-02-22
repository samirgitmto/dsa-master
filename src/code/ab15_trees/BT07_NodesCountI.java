package code.ab15_trees;

/**
 * Recursively visiting the nodes and getting various counts and sum.
 * @author Mohammad Samir
 * @since 21 Sep 2025
 */
public class BT07_NodesCountI {

	/**
	 * to get the total nodes count using recursion
	 * @param head
	 * @return
	 */
	static int totalNodesCount(Node head) {
		int x, y;
		if (head != null) {
			x = totalNodesCount(head.left);
			y = totalNodesCount(head.right);
			return x+y+1;
		}
		return 0;
	}
 	/**
 	 * 
 	 * @param head
 	 * @return nodes with degree 2
 	 */
	static int degreeTwoNodesCount(Node head) {
		int x, y;
		if (head != null) {
			x = degreeTwoNodesCount(head.left);
			y = degreeTwoNodesCount(head.right);
			if (head.left!=null && head.right!=null)
				return x+y+1;
			else
				return x+y;
		}
		return 0;
	}
	
	/**
	 * to get the nodes sum
	 * @param head
	 * @return sum of all nodes value
	 */
	static int totalNodesSum(Node head) {
		int x, y;
		if (head != null) {
			x = totalNodesSum(head.left);
			y = totalNodesSum(head.right);
			return x+y+head.val;
		}
		return 0;
	}
	
	/**
	 * traversing the longest path and then getting the nodes count
	 * @param head
	 * @return longestPathCount
	 */
	static int longestPathCount(Node head) {
		int x, y;
		if (head != null) {
			x = longestPathCount(head.left);
			y = longestPathCount(head.right);
			if (x>y)
				return x+1;
			else
				return y+1;
		}
		return 0;
	}
	
	/**
	 * leaf nodes simply means degree 0.
	 * @param head
	 * @return leaf nodes count
	 */
	static int leafNodesCount(Node head) {
		int x, y;
		if (head!=null) {
			x = leafNodesCount(head.left);
			y = leafNodesCount(head.right);
			if (head.left==null && head.right==null) {
				return x+y+1;
			}
			else
				return x+y;
		}
		return 0;
	}
	/**
	 * get the count of nodes having degree one exactly using exclusive Or (XOR).
	 * @param head
	 * @return degree one nodes count
	 */
	static int countNodesWithDegreeOne(Node head) {
		int x, y;
		if (head!=null) {
			x = countNodesWithDegreeOne(head.left);
			y = countNodesWithDegreeOne(head.right);
//			if ((head.left!=null && head.right==null) || (head.left==null && head.right!=null))
			if ((head.left!=null) ^ (head.right==null))
				return x+y+1;
			else
				return x+y;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.left.right.left = new Node(6);
		head.left.right.right = new Node(7);
		int totalCount = totalNodesCount(head);
		System.out.println("totalCount:" + totalCount);
		int deg2NodesCount = degreeTwoNodesCount(head);
		System.out.println("deg2NodesCount: " + deg2NodesCount);
		int totalSum = totalNodesSum(head);
		System.out.println("totalSum: " + totalSum);
		int longestPathCount = longestPathCount(head);
		System.out.println("longestPathCount: " + longestPathCount);
		int degreeOneNodesCount = countNodesWithDegreeOne(head);
		System.out.println("degreeOneNodesCount: " + degreeOneNodesCount);
	}
	
}