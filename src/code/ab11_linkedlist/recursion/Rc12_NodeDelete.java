package code.ab11_linkedlist.recursion;

public class Rc12_NodeDelete {

	static void traverse(Node head) {
		if (head==null) {
			System.out.println();
			return;
		}
		System.out.print(head.value + " ");
		traverse(head.next);
	}
	
	static Node deleteNodeAtPos(Node head, int pos) {
		if (pos<0) {
			System.err.println("Illegal Aruguments");
			return head;
		}
		if (head == null) {
	        return null; // empty list
	    }
		if (pos==0) {
			head = head.next;
		}
		else {
			Node current = head;
			for (int i=0; i<pos-1 && current!=null; i++) {
				current = current.next;
			}
			 // If position is out of range
		    if (current == null || current.next == null) {
		        System.err.println("Position out of range");
		        return head;
		    }
			
			Node tail = current.next.next;
			current.next = tail;
		}
		return head;
	}
	
	static Node deleteNodeAtPosRecur(Node head, int pos) {
		if (pos<0 || head==null)
			return head;
		if (pos==0) {
			return head.next;
		}
		
		head.next = deleteNodeAtPosRecur(head.next, pos-1);
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		traverse(head);
//		Node modNode = deleteNodeAtPos(head, 0);
//		Node modNode1 = deleteNodeAtPos(head, 1);
		Node modNode1 = deleteNodeAtPosRecur(head, 1);
		traverse(modNode1);
//		Node modNode2 = deleteNodeAtPos(head, 2);
		Node modNode2 = deleteNodeAtPosRecur(head, 2);
		traverse(head);
//		traverse(modNode1);
		traverse(modNode2);
	}
	
}