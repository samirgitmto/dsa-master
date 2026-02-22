package code.ab11_linkedlist.recursion.ps;

public class PS12NodeDelete {

	static NodeI deleteAtPos(NodeI head, int i) {
		if (head == null) {
			return head;
		}
		if (i == 0) {
			return head.next;
		}
		
		int counter = 0;
		NodeI current = head;
		while (current != null) {
			counter++;
			if (counter == i) {
				if (current.next != null) {
					current.next = current.next.next;
				}
				return head;
			}
			current = current.next;
		}
		if (i > counter) {
			System.err.println("out of bounds");
		}
		return head;
	}
	
	static NodeI deleteAtPosRec(NodeI head, int i) {
		if (head == null)
			return head;
		if (i == 0) {
			return head.next;
		}
		head.next = deleteAtPosRec(head.next, i-1);
		return head;
	}
	
	static void traverse(NodeI head) {
		if (head == null) {
			System.out.println();
			return;
		}
		System.out.print(head.val + " ");
		traverse(head.next);
	}
	
	public static void main(String[] args) {
		NodeI node = new NodeI(10);
		node.next = new NodeI(20);
		node.next.next = new NodeI(30);
		node.next.next.next = new NodeI(40);
		node.next.next.next.next = new NodeI(50);
//		NodeI deleteAtPos = deleteAtPos(node, 2);
		NodeI deleteAtPos = deleteAtPosRec(node, 2);
		System.out.println("deleted at i=2, i.e. 30");
		traverse(deleteAtPos);
		traverse(node);
		
//		deleteAtPos = deleteAtPos(deleteAtPos, 0);
		deleteAtPos = deleteAtPosRec(deleteAtPos, 0);
		System.out.println("deleted at i=0, i.e. 10");
		traverse(deleteAtPos);
		traverse(node);
	}
	
}