package code.ab11_linkedlist.recursion.ps;

public class PS10NodeSearch {

//	Real transposition swaps the node with its previous node.
	static NodeI linearSearchMoveToFront(NodeI head, int search) {
		if (head == null)	return head;
		
		NodeI current = head;
		NodeI prev = null;
		while (current != null) {
			if (current.val == search) {
				prev.next = current.next;
				NodeI newHead = new NodeI(search);
				newHead.next = head;
				return newHead;
			}
			prev = current;
			current = current.next;
		}
		return head;
	}
	
	static NodeI searchTransposition(NodeI head, int search) {
		if (head == null || head.val == search)	return head;
		
		NodeI beforePrev = null;
		NodeI prev = head;
		NodeI current = head.next;
		
		while (current != null) {
			if (current.val == search) {
				// transposition
				if (beforePrev != null) {
					beforePrev.next = current;
				} else {
					head = current;
				}
				// swap
				prev.next = current.next;
				current.next = prev;
				return head;
			}
			beforePrev = prev;
			prev = current;
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
		
		traverse(nodeI);
		
//		NodeI newHead = linearSearchMoveToFront(nodeI, 30);
//		traverse(newHead);
//		traverse(nodeI);
		
		System.out.println("transposition");
		NodeI searchTransposition = searchTransposition(nodeI, 30);
		traverse(searchTransposition);
		System.out.println("original");
		traverse(nodeI);
		searchTransposition = searchTransposition(searchTransposition, 30);
		traverse(searchTransposition);
		System.out.println("original");
		traverse(nodeI);
		searchTransposition = searchTransposition(searchTransposition, 30);
		traverse(searchTransposition);
		System.out.println("original");
		traverse(nodeI);
	}
	
}