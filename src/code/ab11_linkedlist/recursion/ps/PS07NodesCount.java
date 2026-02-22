package code.ab11_linkedlist.recursion.ps;

public class PS07NodesCount {

	/**
	 * for singly linked
	 * @param head
	 * @return number of nodes
	 */
	static int countNodes(NodeI head) {
		if (head == null)
			return 0;
		return 1 + countNodes(head.next);
	}
	
	static void traverse(NodeI head) {
		if (head == null) {
			System.out.println();
			return;
		}
		System.out.print(head.val + " ");
		traverse(head.next);
	}
	
	static void traverseCircular(NodeI head) {
		if (head == null) return;
		NodeI current = head;
		do {
			System.out.print(current.val + " ");
			current = current.next;
		}
		while (head != current);
	}
	/**
	 * number of nodes in a circular linked list
	 * @param head
	 * @return count
	 */
	static int countNodesCircular(NodeI head) {
		if (head == null) return 0;
		int count = 0;
		NodeI current = head;
		do {
			count++;
			current = current.next;
		}
		while (head != current);
		return count;
	}
	/**
	 * recursive method to count nodes in a circular linked
	 * @param head
	 * @return count
	 */
	static int countNodesCircularRec(NodeI head) {
		return helper(head, head);
	}
	private static int helper(NodeI head, NodeI start) {
		if (head == null) return 0;
		if (head.next == start) {
			return 1;
		}
		return 1 + helper(head.next, start);
	}

	public static void main(String[] args) {
		NodeI node = new NodeI(10);
		node.next = new NodeI(20);
		node.next.next = new NodeI(30);
		node.next.next.next = new NodeI(40);
		node.next.next.next.next = new NodeI(50);
		System.out.println("singly linked");
		System.out.println(countNodes(node));
		
		
//		NodeI circularNodeI = node; This mutates the same list used for counting singularly.
		// Build a separate circular list
		NodeI circular = new NodeI(10);
		circular.next = new NodeI(20);
		circular.next.next = new NodeI(30);
		circular.next.next.next = new NodeI(40);
		circular.next.next.next.next = new NodeI(50);
		circular.next.next.next.next.next = new NodeI(60);
		// Make it circular
		circular.next.next.next.next.next.next = circular;
		
		traverseCircular(circular);
		System.out.println("\ncircular linked");
		System.out.println(countNodesCircular(circular));
		System.out.println(countNodesCircularRec(circular));
		
		System.out.println("singly linked");
		System.out.println(countNodes(node));
		
		
		
	}
	
}

class NodeI {
	int val;
	NodeI next;
	public NodeI(int x) { this.val = x; }
}
class NodeII {
	int val;
	NodeII prev, next;
	public NodeII(int x) { this.val = x; }
}