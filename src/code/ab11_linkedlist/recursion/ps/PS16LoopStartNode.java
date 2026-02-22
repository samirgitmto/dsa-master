package code.ab11_linkedlist.recursion.ps;

public class PS16LoopStartNode {

	/**
	 * Fast can only complete 1 loop when slow has entered the loop
	 * This makes the approach understandable.
	 * @param head
	 * @return start node of the loop
	 */
	static NodeI getLoopStart(NodeI head) {
		if (head == null)	return null;
		NodeI slow = head;
		NodeI fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		NodeI node = new NodeI(10);
		node.next = new NodeI(20);
		node.next.next = new NodeI(30);
		node.next.next.next = new NodeI(40);
		node.next.next.next.next = new NodeI(50);
		node.next.next.next.next.next = node;
		System.out.println(getLoopStart(node).val);
	}
	
}