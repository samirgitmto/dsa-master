package code.ab11_linkedlist.recursion.ps;

public class PS15MergeSort {

	static NodeI mergeSortedLL(NodeI head1, NodeI head2) {
		if (head1 == null)	return head2;
		if (head2 == null)	return head1;
		
		NodeI p1 = head1;
		NodeI p2 = head2;
		NodeI dummyNode = new NodeI(0);
		NodeI c = dummyNode;
		
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				c.next = p1;
				p1 = p1.next;
			}
			else {
				c.next = p2;
				p2 = p2.next;
			}
			c = c.next;
		}
		
		c.next = p1 != null ? p1 : p2;
		
		return dummyNode.next;
	}
	
	static NodeI mergeSortRec(NodeI h1, NodeI h2) {
		if (h1 == null)	return h2;
		if (h2 == null)	return h1;
		
		NodeI head = h1.val < h2.val ? h1 : h2;
		if (h1.val < h2.val)
			head.next = mergeSortRec(h1.next, h2);
		else
			head.next = mergeSortRec(h1, h2.next);
		
		return head;
	}
	
	public static void main(String[] args) {
		NodeI node = new NodeI(10);
		node.next = new NodeI(20);
		node.next.next = new NodeI(30);
		node.next.next.next = new NodeI(40);
		node.next.next.next.next = new NodeI(50);
		
		NodeI head2 = new NodeI(5);
		head2.next = new NodeI(15);
		head2.next.next = new NodeI(25);
		head2.next.next.next = new NodeI(25);
		head2.next.next.next.next = new NodeI(35);
		
//		NodeI mergedNode = mergeSortedLL(node, head2);
		NodeI mergedNode = mergeSortRec(node, head2);
		traverse(mergedNode);
	}
	
	static void traverse(NodeI head) {
		if (head == null) {
			System.out.println();
			return;
		}
		System.out.print(head.val + " ");
		traverse(head.next);
	}
}
