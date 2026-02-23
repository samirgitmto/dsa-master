package code.ab11_linkedlist.recursion.ps;

import java.util.List;

/**
 * 
 * @since 25-11-2025
 */
public class PS22_LC25_ReverseInKgroup {

	static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode groupPrev = dummy;
        
        while (true) {
        	ListNode kthNode = getKthNode(groupPrev, k);
        	if (kthNode == null)	break;
        	
        	ListNode groupNext = kthNode.next;
        	
        	// reverse group
        	ListNode prev = groupNext;
        	ListNode current = groupPrev.next;
        	
        	while (current != groupNext) {
        		ListNode temp = current.next;
        		current.next = prev;
        		prev = current;
        		current = temp;
        	}
        	
        	ListNode temp = groupPrev.next;
        	groupPrev.next = kthNode;
        	groupPrev = temp;
        }
		
		
		return dummy.next;
    }
	
	private static ListNode getKthNode(ListNode groupPrev, int k) {
		int i = 0;
		while (groupPrev != null && i < k) {
			groupPrev = groupPrev.next;
			i++;
		}
		
		return groupPrev;
	}

	public static void main(String[] args) {
		ListNode head1 = createLL(List.of(1, 2, 3));
		traverse(head1);
		System.out.println();
		ListNode rev = reverseKGroup(head1, 2);
		traverse(rev);
	}
	
	static void traverse(ListNode head) {
		if (head != null) {
			System.out.print(head.val + " ");
			traverse(head.next);
		}		
	}
	
	static ListNode createLL(List<Integer> list) {
		
		ListNode head = new ListNode(list.get(0));
		ListNode current = head;
		for (int i = 1; i < list.size(); i++) {
			current.next = new ListNode(list.get(i));
			current = current.next;
		}
		
		return head;
	}
}