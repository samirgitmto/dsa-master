package code.ab11_linkedlist.recursion;


public class Rc7_NodesCount {

	// count no. of nodes
	// get max value
	
	
	static int countNodes(Node head) {
		if (head==null)
			return 0;
		return countNodes(head.next) + 1;
	}
	
	static void traverse(Node head) {
		while (head!=null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}
	static void traverseRecursive(Node head) {
		if (head==null) {
			System.out.println();
			return;
		}
		System.out.print(head.value + " ");
		traverseRecursive(head.next);
		
	}
	
	static int getMaxVal(Node head) {
		return helper2(head, Integer.MIN_VALUE);
	}
	
	private static int helper(Node head, int maxValue) {
		if (head==null)
			return maxValue;
		
		maxValue = Math.max(maxValue, head.value);
		int localMaxValue = helper(head.next, maxValue);
		
//		return maxValue;
		return Math.max(maxValue, localMaxValue);
	}
	private static int helper2(Node head, int maxValue) {
		if (head==null)
			return maxValue;
		
		maxValue = Math.max(maxValue, head.value);
		return helper(head.next, maxValue);
	}

	static int getMaxValue2(Node head) {
		int x = 0;
		if (head==null) {
			return Integer.MIN_VALUE;
		}
		else {
			x = getMaxValue2(head.next);
			return Math.max(x, head.value);
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(14);
		head.next.next.next.next = new Node(4);
		traverse(head);
		traverseRecursive(head);
		System.out.println(countNodes(head));
		System.out.println(getMaxVal(head));
		System.out.println("getMaxValue2: " + getMaxValue2(head));
	}
	
}

class Node {
	Node next;
	int value;
	public Node(int value) {
		super();
		this.value = value;
	}
	
}