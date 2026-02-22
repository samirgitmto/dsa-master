package code.ab11_linkedlist.recursion.ps;

import java.util.List;

/**
 * 
 * @since 25-11-2025
 */
public class PS22_LC25_ReverseInKgroup {

	static Node reverseKGroup(Node head, int k) {
        if (head == null) return null;
        
        Node dummy = new Node(0);
        dummy.next = head;
        
        Node groupPrev = dummy;
        
        while (true) {
        	Node kthNode = getKthNode(groupPrev, k);
        	if (kthNode == null)	break;
        	
        	Node groupNext = kthNode.next;
        	
        	// reverse group
        	Node prev = groupNext;
        	Node current = groupPrev.next;
        	
        	while (current != groupNext) {
        		Node temp = current.next;
        		current.next = prev;
        		prev = current;
        		current = temp;
        	}
        	
        	Node temp = groupPrev.next;
        	groupPrev.next = kthNode;
        	groupPrev = temp;
        }
		
		
		return dummy.next;
    }
	
	private static Node getKthNode(Node groupPrev, int k) {
		int i = 0;
		while (groupPrev != null && i < k) {
			groupPrev = groupPrev.next;
			i++;
		}
		
		return groupPrev;
	}

	public static void main(String[] args) {
		Node head1 = createLL(List.of(1, 2, 3));
		traverse(head1);
		System.out.println();
		Node rev = reverseKGroup(head1, 2);
		traverse(rev);
	}
	
	static void traverse(Node head) {
		if (head != null) {
			System.out.print(head.val + " ");
			traverse(head.next);
		}		
	}
	
	static Node createLL(List<Integer> list) {
		
		Node head = new Node(list.get(0));
		Node current = head;
		for (int i = 1; i < list.size(); i++) {
			current.next = new Node(list.get(i));
			current = current.next;
		}
		
		return head;
	}
}