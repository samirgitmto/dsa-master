package code.ab11_linkedlist.recursion;

/*
count no. of nodes
get max value

getNodesSum
 */
public class Rc7to9_NodesCount_ps {

	static void traverse(NodePS head) {
		while (head!=null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	static int getNodesCount(NodePS head) {
		if (head==null)
			return 0;
		return getNodesCount(head.next) + 1;
	}
	
	static int getMaxValue(NodePS head) {
		if (head==null)
			throw new IllegalArgumentException("List is empty");
		if (head.next==null)
			return head.value;
		
		return Math.max(head.value, getMaxValue(head.next));
	}
	
	public static void main(String[] args) {
		NodePS head = new NodePS(1);
		head.next = new NodePS(2);
		head.next.next = new NodePS(13);
		head.next.next.next = new NodePS(4);
		head.next.next.next.next = new NodePS(5);
		traverse(head);
		int count = getNodesCount(head);
		System.out.println(count);
		int max = getMaxValue(head);
		System.out.println(max);
		
		head.next.next.next.next.next = new NodePS(16);
		traverse(head);
		int count2 = getNodesCount(head);
		System.out.println(count2);
		int max2 = getMaxValue(head);
		System.out.println(max2);
		
		System.out.println(getMaxValue(null));
	}
	
}

class NodePS {
	int value;
	NodePS next;
	public NodePS(int x) {
		this.value = x;
		this.next = null;
	}
}