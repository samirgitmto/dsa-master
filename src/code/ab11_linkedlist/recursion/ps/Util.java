package code.ab11_linkedlist.recursion.ps;

public class Util {

	static void traverse(ListNode head) {
		if (head != null) {
			System.out.print(head.val + " ");
			traverse(head.next);
		}
	}
	
}
