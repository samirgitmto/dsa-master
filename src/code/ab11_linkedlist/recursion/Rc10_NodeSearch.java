package code.ab11_linkedlist.recursion;

public class Rc10_NodeSearch {

	static boolean linearSearch(Node head, int x) {
		if (head==null)
			return false;
		if (head.value==x)
			return true;
		return linearSearch(head.next, x);
	}
	static Node linearSearchNode(Node head, int x) {
		if (head==null)
			return null;
		if (head.value==x)
			return head;
		return linearSearchNode(head.next, x);
	}
	
	// transposition	(shifting by only 1 node)
	// move to front
	static Node linearSearchMoveToFront(Node head, int x) {
		if (head==null)
			return null;
		if (head.value==x)
			return head;
			
		Node prev = head;
		Node current = head.next;
		while (current!=null) {
			if (current.value == x) {
				prev.next = current.next;
				current.next = head;
//				head=current;   even this also does not make the head same as search1
				// changes the local copy of the head inside the method, but it does not update the head variable in the calling method (main).
				return current;
			}
			prev = current;
			current = current.next;
		}
		return head;
 	}
	// wrong implementation
	static Node linearSearchMoveToFront0(Node head, int x) {
		if (head.next==null) {
			if (head.value==x)
				return head;
			else
				return null;
		}
			
		Node prev = null;
		Node current = head;
		Node first = head;
		while (current!=null) {
			if (current.value == x) {
				prev.next = current.next;
				Node newHead = new Node(x);
				newHead.next = first;
				return newHead;
			}
			prev = current;
			current = current.next;
		}
		return null;
 	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(13);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		traverse(head);
		System.out.println("isPresent " + linearSearch(head, 4));
		System.out.println("isPresent " + linearSearch(head, 14));
		
		Node search1 = linearSearchMoveToFront(head, 13);
//		Node search1 = linearSearchMoveToFront(head, 1);
		System.out.println("traversing search1");
		traverse(search1);
		System.out.println("traversing head");
		traverse(head);     // 1 2 4 5
		head = search1;
		System.out.println("traversing head correctly");
		traverse(head);
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