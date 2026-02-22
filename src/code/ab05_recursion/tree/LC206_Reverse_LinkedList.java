package code.ab05_recursion.tree;

// Definition for singly-linked list.
class Node {
	int val;
	Node next;
	Node() {}
	Node(int val) { this.val = val; }
	Node(int val, Node next) { this.val = val; this.next = next; }
}

public class LC206_Reverse_LinkedList {

	int i = 0;
	
	Node rev(Node listNode) {
		if (listNode==null || listNode.next==null) {
			return listNode;
		}
		i++;
		Node newHead = rev(listNode.next);
		System.err.println(i);
//		i--;
		listNode.next.next = listNode;
		listNode.next = null;
		return newHead;
	}
	Node rev(Node node, int depth) {
	    if (node == null || node.next == null) {
	        System.err.println("Depth at base: " + depth);
	        return node;
	    }
	    Node newHead = rev(node.next, depth + 1);
	    System.err.println("Returning at depth: " + depth);
	    node.next.next = node;
	    node.next = null;
		return newHead;
	}

	
	static void traverse(Node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		traverse(head);
		LC206_Reverse_LinkedList obj = new LC206_Reverse_LinkedList();
//		ListNode revHead = rev(head);
//		ListNode revHead = obj.rev(head);
		Node revHead = obj.rev(head, 0);
		traverse(revHead);
//		traverse(revHead);
	}

}
