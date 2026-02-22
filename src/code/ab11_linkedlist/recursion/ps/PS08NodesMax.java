package code.ab11_linkedlist.recursion.ps;

public class PS08NodesMax {

	static int max(NodeI head) {
		if (head == null)
			return 0;
		
		return Math.max(head.val, max(head.next));
	}
	
	public static void main(String[] args) {
		NodeI nodeI = new NodeI(10);
		nodeI.next = new NodeI(20);
		nodeI.next.next = new NodeI(90);
		nodeI.next.next.next = new NodeI(40);
		nodeI.next.next.next.next = new NodeI(50);
		
		System.out.println(max(nodeI));
	}
	
}