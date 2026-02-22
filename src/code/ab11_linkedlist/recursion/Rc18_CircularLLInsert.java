package code.ab11_linkedlist.recursion;

public class Rc18_CircularLLInsert {
	
	static Node insertIntoCircularLLAtPos(Node head, int x, int pos) {
		if (head==null) {
			Node insert = new Node(x);
			insert.next = insert;
			return insert;
		}
		if (pos==0) {
			Node tail = head;
			while (tail.next!=head)	tail=tail.next;
			tail.next = null;
			Node insert = new Node(x);
			insert.next = head;
			tail.next = insert;
			return head;
		}
		else {
			Node tail = head;
			for (int i=0; i<pos-1; i++) {
				tail = tail.next;
			}
//			tail.next = null;
			Node insert = new Node(x);
			insert.next = tail.next;
			tail.next = insert;
		}
		return head;
	}
	
	public static void main(String[] args) throws Exception {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = head;
//		display(head);
//		displayRecur(head);
		displayRecurConcurrent(head, head);
		
//		Node modNode = insertIntoCircularLLAtPos(head, 15, 0);
		Node modNode = insertIntoCircularLLAtPos(head, 15, 2);
		displayRecurConcurrent(head, head);
		displayRecurConcurrent(modNode, modNode);
		System.out.println(isCircular(modNode));
//		traverse(modNode);
	}
	
	static void displayRecurConcurrent(Node head, Node start) {
		if (head==null) return;
		System.out.print(head.value + " ");
		if (head.next == start) {
			System.out.println();
			return;
		}
		displayRecurConcurrent(head.next, start);
	}
	static boolean isCircular(Node head) {
		if (head==null)
			return false;
		Node temp = head.next;
		while (temp.next!=null && temp!=head) {
			temp = temp.next;
		}
		return temp==head;
	}
	static void traverse(Node head) {
		if (head==null) {
			System.out.println();
			return;
		}
		System.out.print(head.value + " ");
		traverse(head.next);
	}
}