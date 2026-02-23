package code.ab11_linkedlist.recursion.ps;

/**
 * middle node
 * second middle if there are 2 middle nodes
 * 1 2 3 4
 * 3 is the middle here
 */
public class PS26_LC876_MiddleNode {

	/**
	 * using slow and fast pointers
	 * @param head
	 * @return
	 */
	static ListNode middleNode(ListNode head) {
		if (head == null) return head;
		ListNode fast = head, slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
		node.next.next.next = new ListNode(40);
		node.next.next.next.next = new ListNode(50);
		Util.traverse(node);
		System.out.println();
		System.out.println(middleNode(node).val);
	}
}
