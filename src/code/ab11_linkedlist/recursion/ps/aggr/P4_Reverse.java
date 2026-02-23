package code.ab11_linkedlist.recursion.ps.aggr;

public class P4_Reverse {

	/**
	 * 1 2 3 4 5 (l=1, r=4)
	 * 1 4 3 2 5
	 * @param head
	 * @param left
	 * @param right
	 * @return
	 */
	static ListNode reverseBetween(ListNode head, int left, int right) {
    	if (left == 1) {
    		return rev(head, right);
    	}
    	head.next = reverseBetween(head.next, left-1, right-1);
    	return head;
    }
	// 2 3 4 5
    private static ListNode successorNode = null;
    static ListNode rev(ListNode head, int right) {
    	if (right == 1) {
    		successorNode = head.next;
    		return head;
    	}
    	ListNode revHead = rev(head.next, right-1);
    	head.next.next = head;
    	head.next = successorNode;
    	return revHead;
    }
	
	public static void main(String[] args) {
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
		node.next.next.next = new ListNode(40);
		node.next.next.next.next = new ListNode(50);
		
		ListNode reverseBetween = reverseBetween(node, 2, 4);
		Util.traverse(reverseBetween);
	}
}
