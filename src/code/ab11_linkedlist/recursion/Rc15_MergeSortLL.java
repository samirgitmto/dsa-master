package code.ab11_linkedlist.recursion;

public class Rc15_MergeSortLL {
// merge two sorted LinkedLists
	
	static void traverse(Node head) {
		if (head==null) {
			System.out.println();
			return;
		}
		System.out.print(head.value + " ");
		traverse(head.next);
	}
	static Node mergeSortedLL(Node head, Node tail) {
		if (head==null)
			return tail;
		if (tail==null)
			return head;
		Node first = head;
		Node second = tail;
		Node third;
		Node last;
		
		if (first.value < second.value) {
			third = last = first;
			first = first.next;
			last.next = null;
		}
		else {
			third = last = second;
			second = second.next;
			last.next = null;
		}
		
		while (first!=null && second!=null) {
			if (first.value < second.value) {
				last.next = first;
				last = first;
				first = first.next;
				last.next = null;
			}
			else {
				last.next = second;
				last = second;
				second = second.next;
				last.next = null;
			}
		}
		
		if (first!=null) {
			last.next = first;
		}
		else if (second!=null) {
			last.next = second;
		}
		return third;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(13);
		head.next.next.next = new Node(14);
		head.next.next.next.next = new Node(15);
		traverse(head);
		Node tail = new Node(2);
		tail.next = new Node(4);
		tail.next.next = new Node(7);
		tail.next.next.next = new Node(9);
		tail.next.next.next.next = new Node(10);
		traverse(tail);
		
		Node merged = mergeSortedLL(head, tail);
		traverse(merged);
	}
}