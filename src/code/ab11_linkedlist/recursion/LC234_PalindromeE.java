package code.ab11_linkedlist.recursion;

import java.util.Stack;

public class LC234_PalindromeE {

	static boolean isPalindrome(Node head) {
		return helper(head, new Stack<Node>());
	}
	private static boolean helper(Node head, Stack<Node> stack) {		
		boolean isEqual = true;
		if (head!=null) {
			isEqual = helper(head.next, stack);
//			return isEqual;
		}
			
		stack.push(head);
		if (!isEqual)
			return false;
		
		return stack.pop().value == head.value;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		System.out.println(isPalindrome(head));
	}
	
}