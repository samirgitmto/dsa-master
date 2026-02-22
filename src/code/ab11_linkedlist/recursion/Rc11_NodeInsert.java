package code.ab11_linkedlist.recursion;

public class Rc11_NodeInsert {

	static void traverse(Node head) {
		if (head==null) {
			System.out.println();
			return;
		}
		System.out.print(head.value + " ");
		traverse(head.next);
	}
	static Node insertAtPos(Node head, int x, int pos) {
		// if pos = 0; insert at start
		if (pos==0) {
			Node insert = new Node(x);
			insert.next = head;
			return insert;
		}
		else if (pos>0) {
			Node insert = new Node(x);
			Node current = head;
			for (int i=0; i<pos-1 && current!=null; i++) {
				current = current.next;
			}
			if (current==null) {
				System.err.println("can't be inserted as list does not contain enough elements");
				return head;
			}
			Node tail = current.next;
			insert.next = tail;
			current.next = insert;
			return head;
		}
		return head;
	}
	
	static Node insertAtPosRecur0(Node head, int x, int pos) {
		if (head==null) {
			return new Node(x);
		}
		if (pos<0)
			return head;
		if (pos==0) {
			Node newHead = new Node(x);
			newHead.next = head;
			return newHead;
		}
		if (pos==1) {
			Node tail = head.next;
			Node insert = new Node(x);
			head.next = insert;
			head.next.next = tail;
			return head;
		}
		insertAtPosRecur0(head.next, x, pos-1);
		return head;
	}
	static Node insertAtPosRecur(Node head, int x, int pos) {
		if (pos<0)
			return head;

		if (pos==0) {
			Node insert = new Node(x);
			insert.next = head;
			return insert;
		}
		if (head==null) {
//			return new Node(x);		// if we want to append even if the size is smaller
			return head;			// to prevent appending to the list if size is smaller
		}
		head.next = insertAtPosRecur(head.next, x, pos-1);
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		traverse(head);
//		Node withInsertedNode = insertAtPos(head, 14, 0);
//		Node withInsertedNode = insertAtPos(head, 14, 4);
//		Node withInsertedNode = insertAtPosRecur0(head, 14, 4);
		Node withInsertedNode = insertAtPosRecur(head, 14, 0);
		traverse(head);
		traverse(withInsertedNode);
	}
	
}