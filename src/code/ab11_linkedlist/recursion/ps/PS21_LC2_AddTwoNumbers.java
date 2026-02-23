package code.ab11_linkedlist.recursion.ps;

import java.util.List;

/**
 * 
 */
public class PS21_LC2_AddTwoNumbers {

	static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        
		ListNode summedNode = sumNodes(node1, node2, 0);
		
		return summedNode;
    }

	private static ListNode sumNodes(ListNode node1, ListNode node2, int carryover) {
		if (node1 == null && node2 == null) {
			return carryover > 0 ? new ListNode(carryover) : null;
		}
		
		int x = 0, y = 0;
		
		ListNode nextNode1 = null;
		ListNode nextNode2 = null;
		
		if (node1 != null) {
			x = node1.val;
			nextNode1 = node1.next;
		}
		if (node2 != null) {
			y = node2.val;
			nextNode2 = node2.next;
		}
		
		int sum = x + y + carryover;
		int value = (sum) % 10;
		ListNode newNode = new ListNode(value);
		carryover = sum / 10;
		newNode.next = sumNodes(nextNode1, nextNode2, carryover);
		
		return newNode;
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
	
	public static void main(String[] args) {
//		[9,9,9,9,9,9,9]
		ListNode head1 = createLL(List.of(9, 9, 9, 9, 9, 9, 9));
		traverse(head1);
		System.out.println();
//		[9,9,9,9]
		ListNode head2 = createLL(List.of(9, 9, 9, 9));
		
		ListNode summedNode = addTwoNumbers(head1, head2);
		traverse(summedNode);	// [8,9,9,9,0,0,0,1]
		System.out.println();
	}
	
}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		this.val = x;
	}
}