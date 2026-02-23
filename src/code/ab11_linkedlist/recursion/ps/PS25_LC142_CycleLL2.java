package code.ab11_linkedlist.recursion.ps;

/**
 * detecting the entry point of cycle
 */
public class PS25_LC142_CycleLL2 {

	static ListNode detectCycle(ListNode head) {
		if (head == null)	return head;
		
		ListNode fast = head, slow = head;
		byte hasCycle = 0;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) { 
				hasCycle = 1;
				break;
			}
		}
		
		if (hasCycle == 0)	return null;
		
		fast = head;
		while (fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
		node.next.next.next = new ListNode(40);
//		node.next.next.next.next = new ListNode(50);
		node.next.next.next.next = node;
		
		ListNode detectedNode = detectCycle(node);
		System.out.println(detectedNode.val);
	}
	
}
