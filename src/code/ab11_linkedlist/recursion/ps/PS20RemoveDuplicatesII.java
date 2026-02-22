package code.ab11_linkedlist.recursion.ps;

public class PS20RemoveDuplicatesII {

	static NodeI removeDuplicatesII(NodeI head) {
		if (head == null || head.next == null)
			return head;
		
		NodeI dummy = new NodeI(head.val - 1);
		dummy.next = head;
		
		NodeI prev = dummy;
		NodeI current = head;
		
		while (current != null) {
			// Detect Duplicates: move curr forward while values match
			while (current.next != null && current.val == current.next.val) {
				current = current.next;
			}
			
			// playing with node reference
			if (prev.next == current) {
				// No duplicate for this value - keep node
				prev = prev.next;
			}
			else {
				// different nodes
				// Duplicate detected - skip entire block
				prev.next = current.next;
			}
			current = current.next;
		}
			
		return dummy.next;
	}
	
	public static void main(String[] args) {
		NodeI node = new NodeI(10);
		node.next = new NodeI(10);
		node.next.next = new NodeI(20);
		node.next.next.next = new NodeI(30);
		node.next.next.next.next = new NodeI(50);
		
		NodeI mod = removeDuplicatesII(node);
		traverse(mod);
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
