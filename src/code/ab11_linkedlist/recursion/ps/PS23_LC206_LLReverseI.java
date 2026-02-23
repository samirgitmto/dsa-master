package code.ab11_linkedlist.recursion.ps;

public class PS23_LC206_LLReverseI {

	static ListNode reverse(ListNode head) {
		if (head == null)	return head;
		ListNode prev = null;
		ListNode current = head;
		
		while (current != null) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		
		return prev;
	}
	
	static ListNode reverseRec(ListNode head) {
		if (head.next == null)	return head;
		ListNode reversedHead = reverseRec(head.next);
		head.next.next = head;
		head.next = null;
		return reversedHead;
	}
	public static void main(String[] args) {
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
		node.next.next.next = new ListNode(40);
		node.next.next.next.next = new ListNode(50);
		
		traverse(node);
		System.out.println();
//		Node reversedNode = reverse(node);
//		traverse(reversedNode);
		System.out.println();
		traverse(node);
		System.out.println();
		
		ListNode reversedNode2 = reverseRec(node);
		traverse(reversedNode2);
	}
	
	static void traverse(ListNode head) {
		if (head != null) {
			System.out.print(head.val + " ");
			traverse(head.next);
		}
	}
}