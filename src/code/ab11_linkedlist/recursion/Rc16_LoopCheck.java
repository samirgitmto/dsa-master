package code.ab11_linkedlist.recursion;

public class Rc16_LoopCheck {

//	This works in most cases, but it means you don’t check for slow == fast at the very beginning, and it shifts the loop detection one step.
	static boolean isLoop0(Node head) {
		if (head==null || head.next==null)
			return false;
		Node slow = head;
		Node fast = head.next;
		while (fast!=null && fast.next!=null) {
			if (slow==fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
	static boolean isLoop(Node head) {
		if (head==null || head.next==null)
			return false;
		Node slow = head;
		Node fast = head;
		while (fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow==fast) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		Node start = new Node(3);
		head.next.next = start;
//		head.next.next.next = new Node(4);
		start.next = new Node(4);
		Node tail = new Node(5);
		start.next.next = tail;
		tail.next = start;
		
//		head.next.next.next.next = new Node(5);
//		traverse(head);
		boolean isLoop = isLoop(head);
		System.out.println(isLoop);
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