package code.ab11_linkedlist.recursion;

public class Rc14_LLConcat {

	static void traverse(Node head) {
		if (head==null) {
			System.out.println();
			return;
		}
		System.out.print(head.value + " ");
		traverse(head.next);
	}
	
	static Node concat(Node head, Node tail) {
		Node current = head;
		while (current.next!=null) {
			current = current.next;
		}
		current.next = tail;
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		traverse(head);
		Node tail = new Node(10);
		tail.next = new Node(2);
		tail.next.next = new Node(3);
		tail.next.next.next = new Node(4);
		tail.next.next.next.next = new Node(5);
		traverse(tail);
		
		Node concatNode = concat(head, tail);
		traverse(concatNode);
	}
	
}