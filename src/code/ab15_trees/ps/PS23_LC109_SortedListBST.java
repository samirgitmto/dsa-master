package code.ab15_trees.ps;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * 
 * @author Mohammad Samir
 * 
 * @since 13-10-2026
 */
public class PS23_LC109_SortedListBST {

	static ListNode prev = null;
	static TreeNode sortedListToBST(ListNode head) {
		if (head == null)	return null;
		prev = null;
		
		return dACBinary(head);
    }
	
	private static TreeNode dACBinary(ListNode head) {
		if (head == null)	return null;
		if (head.next == null)	return new TreeNode(head.val);
		
		ListNode mid = getMiddleNode(head);
		
		if (prev != null)	prev.next = null;
		
		TreeNode root = new TreeNode(mid.val);
		
		root.left = dACBinary(head);
		root.right = dACBinary(mid.next);
		
		return root;
	}

	private static ListNode getMiddleNode(ListNode head) {
		if (head == null)	return null;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	static void inOrderTraversal(TreeNode head) {
		if (head!=null) {
			inOrderTraversal(head.left);
			System.out.print(head.val + " ");
			inOrderTraversal(head.right);
		}
	}
	
	public static void main(String[] args) {
		// head = [-10,-3,0,5,9] // sorted means inorder
		ListNode listNode = new ListNode(-10);
		listNode.next = new ListNode(-3);
		listNode.next.next = new ListNode(0);
		listNode.next.next.next = new ListNode(5);
		listNode.next.next.next.next = new ListNode(9);
		
		TreeNode root = sortedListToBST(listNode);
		inOrderTraversal(root);
		
	}
}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		this.val = x;
	}
}