package code.ab11_linkedlist.recursion.ps.aggr;

import java.util.List;

public class Util {

	static void traverse(ListNode head) {
		if (head != null) {
			System.out.print(head.val + " ");
			traverse(head.next);
		}
	}
	
	static ListNode createLL(List<Integer> list) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		for (Integer integer : list) {
			head.next = new ListNode(integer);
			head = head.next;
		}
		return dummy.next;				
	}
}
