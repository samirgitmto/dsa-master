package code.ab11_linkedlist.recursion.ps;

public class PS16LoopCheck {

	/**
	 * time complexity: O(n)
	 * check if the list has a loop
	 * @param head
	 * @return whether it has loop or not
	 */
	static boolean hasLoop(NodeI head) {
		if (head == null)	return false;
		NodeI slow = head;
		NodeI fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)	return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		NodeI node = new NodeI(10);
		node.next = new NodeI(20);
		node.next.next = new NodeI(30);
		node.next.next.next = new NodeI(40);
		node.next.next.next.next = new NodeI(50);
		node.next.next.next.next.next = node;
		System.out.println(hasLoop(node));
//		traverse(node);
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