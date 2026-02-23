package code.ab11_linkedlist.recursion.ps.aggr;

import java.util.List;

public class P3_DuplicatesLL {

	/**
	 * LC 82 MEDIUM
	 * keep only the unique ones
	 * 1 2 3 3 4 4 5
	 * 1 2 5
	 * @param head
	 * @return head
	 */
    static ListNode deleteDuplicates(ListNode head) {
    	if (head == null) return null;
    	int prev = head.val + 1;
    	ListNode dummy = new ListNode(prev);
    	ListNode current = dummy;
    	
    	while (head != null && head.next != null) {
    		if (head.val != prev && head.val != head.next.val) {
    			current.next = head;
    			current = current.next;
    		}
    		
    		prev = head.val;
    		head = head.next;
    		current.next = null;
    	}
    	if (prev != head.val)
    		current.next = head;
    	
    	return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
		node.next.next.next = new ListNode(30);
		node.next.next.next.next = new ListNode(40);
		node.next.next.next.next.next = new ListNode(40);
		node.next.next.next.next.next.next = new ListNode(50);
		
		Util.traverse(node);
		System.out.println();
		
		ListNode deleteDuplicates = deleteDuplicates(node);
		Util.traverse(deleteDuplicates);
		System.out.println();
		
		ListNode ll = Util.createLL(List.of(1, 2, 2));
		ListNode deleteDuplicates2 = deleteDuplicates(ll);
		Util.traverse(deleteDuplicates2);
	}
	
}
