package code.ab11_linkedlist.recursion.ps;

public class PS11NodesInsert {

	static NodeI insertAtPos(NodeI head, int x, int i) {
		NodeI current = head;
		if (head == null || i==0) {
			NodeI newHead = new NodeI(x);
			newHead.next = current;
			return newHead;
		}
		
		int counter = 0;
//		NodeI current = head;
		while (current != null) {
			counter++;
			if (counter == i) {
				NodeI tail = current.next;
				current.next = new NodeI(x);
				current.next.next = tail;
				return head;
			}
			current = current.next;
		}
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
		NodeI nodeI = new NodeI(10);
		nodeI.next = new NodeI(20);
		nodeI.next.next = new NodeI(30);
		nodeI.next.next.next = new NodeI(40);
		nodeI.next.next.next.next = new NodeI(50);
		insertAtPos(nodeI, 25, 2);
		traverse(nodeI);
		insertAtPos(nodeI, 15, 1);
		traverse(nodeI);
		NodeI insertAtPos = insertAtPos(nodeI, 05, 0);
		traverse(nodeI);
		traverse(insertAtPos);
	}
	
}