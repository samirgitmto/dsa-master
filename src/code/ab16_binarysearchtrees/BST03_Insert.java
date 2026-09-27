package code.ab16_binarysearchtrees;

/**
 * 
 * @since 21-09-2025
 */
public class BST03_Insert {

	/**
	 * Complexity: Time O(log n)	Space O(H)
	 * @param head
	 * @param val
	 * @return
	 */
	static Node insertRecur(Node head, int val) {
		Node insert = null;
		if (head == null) {
			insert = new Node(val);
			// above node constructor will make left and right child null.
			return insert;
		}
		if (val < head.val) {
			head.left = insertRecur(head.left, val);
		}
		else if (val > head.val) {
			head.right = insertRecur(head.right, val);
		}
		return head;
	}
	
	static void inOrderTraversal(Node head) {
		if (head!=null) {
			inOrderTraversal(head.left);
			System.out.print(head.val + " ");
			inOrderTraversal(head.right);
		}
	}
	
	public static void main(String[] args) {
		Node head = insertRecur(null, 30);
		Node head2 = insertRecur(head, 30);
		inOrderTraversal(head);
		System.out.println();
		inOrderTraversal(head2);
		System.out.println();
		
		insertRecur(head, 20);
		inOrderTraversal(head);
		System.out.println();
		
		insertRecur(head, 40);
		inOrderTraversal(head);
		System.out.println();
		
		Solution solution = new Solution();
		Node node3 = new Node(4);
		node3.left = new Node(2);
		node3.right = new Node(6);
		solution.insertIntoBST(node3, 1);
		inOrderTraversal(node3);
	}
	
}
/**
 * @since 15-05-2026
 */
class Solution {
    public Node insertIntoBST(Node root, int val) {
    	if (root == null) {
    		root = new Node(val);
    	}
    	else if (val < root.val) {
    		root.left = insertIntoBST(root.left, val);
    	}
    	else if (val > root.val) {
    		root.right = insertIntoBST(root.right, val);
    	}
    	
    	return root;
    }
}