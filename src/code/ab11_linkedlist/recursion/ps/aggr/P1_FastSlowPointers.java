package code.ab11_linkedlist.recursion.ps.aggr;

/**
 * All forms of problems which can be solved using fast and slow pointers.
 * Fast may mean differently based on requirements.
 */
public class P1_FastSlowPointers {

	/**
	 * MEDIUM
	 * 10 20 (2) --> 20
	 * @param head
	 * @param n
	 * @return head
	 */
    static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)	return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        
        int i = 0;
        while (i <= n) {
        	fast = fast.next;
        	i++;
        }
        
        while (fast != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
		node.next.next.next = new ListNode(40);
		node.next.next.next.next = new ListNode(50);
		Util.traverse(node);
		System.out.println();
		
		ListNode removeNthFromEnd = removeNthFromEnd(node, 2);
		Util.traverse(removeNthFromEnd);
		System.out.println();
		
		ListNode node2 = new ListNode(10);
		ListNode removeNthFromEnd2 = removeNthFromEnd(node2, 1);
		System.out.println(removeNthFromEnd2);
		node2.next = new ListNode(20);
		ListNode removeNthFromEnd22 = removeNthFromEnd(node2, 2);
		Util.traverse(removeNthFromEnd22);
	}
	
}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		this.val = x;
		this.next = null;
	}
}