package code.ab11_linkedlist.recursion;

public class Rc9_NodeSearch {

	static Boolean isPresent(Node head, int x) {
		if (head==null) {
			return false;
		}
		else if (head.value == x) {
			return true;
		}
		return isPresent(head.next, x);
	}
	
	static void traverse(Node head) {
		while (head!=null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(14);
		head.next.next.next.next = new Node(4);
		traverse(head);
		System.out.println(isPresent(head, 14));
		System.out.println(isPresent(head, 15));
	}
	
}