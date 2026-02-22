package code.ab11_linkedlist.recursion;

public class Rc17_CircularLinkedList {

	static void display(Node head) {
		if (head==null)
			return;
		Node current = head;
		do {
			System.out.print(current.value + " ");
			current = current.next;
		} while (current!=head);
		System.out.println();
	}
	
//	not thread safe
	static Node CURRENT;
	static Node displayRecur(Node head) throws InterruptedException {
		if (head==null)
			return head;
		if (CURRENT==null) {
			CURRENT = head;
		}
		System.out.print(head.value + " ");
		if (head.next == CURRENT) {
			System.out.println();
			CURRENT = null;
			return null;
		}		
		Node current = displayRecur(head.next);
		return current;
	}
	
//	to avoid shared state
	static void displayRecurConcurrent(Node head, Node start) {
		if (head==null) return;
		System.out.print(head.value + " ");
		if (head.next == start)
			return;
		displayRecurConcurrent(head.next, start);
	}
	
	public static void main(String[] args) throws Exception {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = head;
		display(head);
		displayRecur(head);
		displayRecurConcurrent(head, head);
	}
	
}