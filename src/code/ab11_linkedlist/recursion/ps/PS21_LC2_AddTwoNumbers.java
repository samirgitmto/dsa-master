package code.ab11_linkedlist.recursion.ps;

import java.util.List;

/**
 * 
 */
public class PS21_LC2_AddTwoNumbers {

	static Node addTwoNumbers(Node node1, Node node2) {
        
		Node summedNode = sumNodes(node1, node2, 0);
		
		return summedNode;
    }

	private static Node sumNodes(Node node1, Node node2, int carryover) {
		if (node1 == null && node2 == null) {
			return carryover > 0 ? new Node(carryover) : null;
		}
		
		int x = 0, y = 0;
		
		Node nextNode1 = null;
		Node nextNode2 = null;
		
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
		Node newNode = new Node(value);
		carryover = sum / 10;
		newNode.next = sumNodes(nextNode1, nextNode2, carryover);
		
		return newNode;
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
	
	public static void main(String[] args) {
//		[9,9,9,9,9,9,9]
		Node head1 = createLL(List.of(9, 9, 9, 9, 9, 9, 9));
		traverse(head1);
		System.out.println();
//		[9,9,9,9]
		Node head2 = createLL(List.of(9, 9, 9, 9));
		
		Node summedNode = addTwoNumbers(head1, head2);
		traverse(summedNode);	// [8,9,9,9,0,0,0,1]
		System.out.println();
	}
	
}

class Node {
	int val;
	Node next;
	public Node(int x) {
		this.val = x;
	}
}