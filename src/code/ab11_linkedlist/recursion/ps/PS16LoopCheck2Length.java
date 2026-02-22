package code.ab11_linkedlist.recursion.ps;

import java.util.HashSet;
import java.util.Set;

public class PS16LoopCheck2Length {

	/**
	 * iterative method using Floyd's cycle detection approach
	 * time complexity: O(n) + O(k) = O(n)  here n for list size and k for loop length
	 * @param head
	 * @return loop length
	 */
	private static int getLoopLength(NodeI head) {
		if (head == null)	return 0;
		
		NodeI slow = head;
		NodeI fast = head;
		int length = 0;
		boolean hasLoop = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasLoop = true;
				slow = slow.next;
				length++;
				break;
			}
		}
		if (!hasLoop)	return 0;
		while (slow != fast) {
			slow = slow.next;
			length++;
		}
		
		return length;
	}
	
	private static int getLoopLengthRec(NodeI head) {
		if (head == null)	return 0;
		NodeI startNode = detectStartNode(head, new HashSet<NodeI>());
		
		return countLengthRecursive(startNode.next, startNode, 1);
	}
	private static int countLengthRecursive(NodeI head, NodeI start, int count) {
		if (head == null)	return 0;
		if (head == start) {
			return count;
		}
		return countLengthRecursive(head.next, start, count+1);
	}
	
	private static NodeI detectStartNode(NodeI head, Set<NodeI> visited) {
        if (head == null)   return null;
        if (visited.contains(head))
            return head;
        visited.add(head);
        return detectStartNode(head.next, visited);
    }
	
	public static void main(String[] args) {
		NodeI node = new NodeI(10);
		node.next = new NodeI(20);
		node.next.next = new NodeI(30);
		node.next.next.next = new NodeI(40);
		node.next.next.next.next = new NodeI(50);
		node.next.next.next.next.next = node;
//		System.out.println(getLoopLength(node));
		System.out.println(getLoopLengthRec(node));
	}
	
}