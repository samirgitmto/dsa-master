package code.ab11_linkedlist.recursion.ps;

/**
 * Hare & Tortoise approach
 * using fast and slow pointers
 */
public class PS24_LC141_CycleLL {

	static boolean hasCycle(ListNode head) {
		if (head == null)	return false;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast)	return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
		node.next.next.next = new ListNode(40);
		node.next.next.next.next = new ListNode(50);
		node.next.next.next.next = node;
//		Util.traverse(node);
		boolean hasCycle = hasCycle(node);
		System.out.println(hasCycle);
		
		System.out.println(hasCycle(new ListNode(10)));
	}
}
