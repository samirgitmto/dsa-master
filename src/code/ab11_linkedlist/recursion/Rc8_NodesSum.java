package code.ab11_linkedlist.recursion;

public class Rc8_NodesSum {

	static int sum(Node head) {
		if (head==null)
			return 0;
		return sum(head.next) + head.value;
	}
	
	static void traverse(Node head) {
		while (head != null) {
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
		
		System.out.println(sum(head));
	}
	
}