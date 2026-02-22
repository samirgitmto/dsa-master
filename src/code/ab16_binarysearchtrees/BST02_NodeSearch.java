package code.ab16_binarysearchtrees;

/**
 * 
 * @since 21-09-2025
 */
public class BST02_NodeSearch {

	/**
	 * recursive
	 * Complexity: Time O(log n)    Space O(log n)
	 * @param head
	 * @param key
	 * @return node if present
	 */
	static Node search(Node head, int key) {
		if (head==null)
			return null;
		if (key == head.val)
			return head;
		else if (key < head.val)
			return search(head.left, key);
		else
			return search(head.right, key);
		
	}
	static boolean isPresent(Node head, int key) {
		if (search(head, key)==null)
			return false;
		return true;
	}
	
	/**
	 * iterative approach
	 * Complexity: Time O(log n)   Space O(1)
	 * @param root
	 * @param key
	 * @return
	 */
	static boolean isPresentIter(Node root, int key) {
		if (root == null)	return false;
		
		Node current = root;
		
		while (current != null) {
			if (current.val == key)	return true;
			else if (current.val > key) {
				current = current.left;
			}
			else
				current = current.right;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Node head = new Node(30);
		head.left = new Node(20);
		head.right = new Node(40);
		head.left.left = new Node(10);
		head.left.right = new Node(25);
		head.right.left = new Node(35);
		head.right.right = new Node(50);
		System.out.println(isPresent(head, 25));
		System.out.println(isPresentIter(head, 25));
		System.out.println(isPresentIter(head, 26));
	}	
}

class Node {
	int val;
	Node left, right;
	public Node(int x) {
		this.val = x;
	}
}