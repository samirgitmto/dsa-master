package code.ab15_trees;

public class BT05_PostOrderIterative {

	static void postOrderIterative(Node head) {
			
	}
	public static void main(String[] args) {

		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.left.right.left = new Node(6);
		head.left.right.right = new Node(7);
		postOrderIterative(head);
	}
	
}