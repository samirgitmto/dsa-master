package code.ab11_linkedlist.recursion;

public class Rc13_NodeisSortedDuplicates {
	
	static boolean isSortedRecur(Node head) {
		if (head==null || head.next==null)
			return true;
		int x = head.value;
		int y = head.next.value;
		if (x<=y) {
			return isSortedRecur(head.next);
		}
		else
			return false;
	}
	
	static Node removeDuplicates(Node head) {
		if (head==null || head.next==null)
			return head;
		Node current = head;
		while (current!=null && current.next!=null) {
			if (current.value==current.next.value) {
				current.next = current.next.next;
			}
			else
				current = current.next;
		}
		return head;
	}
	
//	static Node removeDuplicatesRecursive(Node head) {
//		if (head == null || head.next==null)
//			return head;
//		
//	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(5);
		traverse(head);
		boolean isSorted = isSortedRecur(head);
		System.out.println(isSorted);
		Node headWithUniques = removeDuplicates(head);
		traverse(headWithUniques);
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