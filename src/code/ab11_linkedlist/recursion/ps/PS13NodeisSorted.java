package code.ab11_linkedlist.recursion.ps;

public class PS13NodeisSorted {
	
	static boolean isSorted(NodeI head) {
		if (head == null)	return true;
		
		NodeI current = head;
		int prev = Integer.MIN_VALUE;
		while (current != null) {
			if (current.val < prev)
				return false;
			prev = current.val;
			current = current.next;
		}
		return true;
	}
	
	static boolean isSortedRec(NodeI head) {
		if (head == null || head.next == null)
			return true;
		int x = head.val;
		int y = head.next.val;
		if (y >= x) {
			return isSortedRec(head.next);
		}
		return false;
	}
	
	static boolean isSortedRec2(NodeI head) {
		if (head == null || head.next == null)
			return true;
		return head.next.val>=head.val && isSortedRec2(head.next);
	}
	
	public static void main(String[] args) {
		NodeI node = new NodeI(10);
		node.next = new NodeI(20);
		node.next.next = new NodeI(30);
		node.next.next.next = new NodeI(40);
		node.next.next.next.next = new NodeI(50);
		System.out.println(isSorted(node));
		System.out.println(isSortedRec(node));
		System.out.println(isSortedRec2(node));
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
