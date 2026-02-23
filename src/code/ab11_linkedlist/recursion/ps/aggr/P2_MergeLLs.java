package code.ab11_linkedlist.recursion.ps.aggr;

/**
 * intersection pt
 * 1 2 3
 *       4 5
 *   7 8
 * here 4 is that pt.
 */
public class P2_MergeLLs {

	/**
	 * A: 10,20,30, 40,50,  70,80, 40,50
     * B: 70,80, 40,50,  10,20,30, 40,50
	 * @param headA
	 * @param headB
	 * @return intersectionNode
	 */
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode h1 = headA;
    	ListNode h2 = headB;
    	
    	while (h1 != h2) {
    		h1 = (h1 == null) ? headB : h1.next;
    		h2 = (h2 == null) ? headA : h2.next;
		}
    	
    	return h1;
    }
	
    
    /**
     * BAD CODE
     * merge 2 sorted lists in sorted manner
     * @param list1
     * @param list2
     * @return head
     */
    static ListNode mergeTwoLists0(ListNode list1, ListNode list2) {
    	if (list1 == null)	return list2;
    	if (list2 == null)	return list1;
    	
    	ListNode p1 = list1;
    	ListNode p2 = list2;
    	ListNode current = new ListNode(0);
    	
    	ListNode merged;
    	if (p1.val <= p2.val) {
    		merged = new ListNode(p1.val);
    		p1 = p1.next;
    	}
    	else {
    		merged = new ListNode(p2.val);
    		p2 = p2.next;
    	}
    	current.next = merged;
    	while (p1 != null && p2 != null) {
    		if (p1.val <= p2.val) {
    			merged.next = new ListNode(p1.val);
    			p1 = p1.next;
    		}
    		else {
    			merged.next = new ListNode(p2.val);
    			p2 = p2.next;
    		}
    		merged = merged.next;
    	}
    	if (p1 != null) {
    		merged.next = p1;
    	}
    	else
    		merged.next = p2;
    	
    	return current.next;
    }
    /**
     * Optimal One
     * @param list1
     * @param list2
     * @return
     */
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	ListNode dummy = new ListNode(0);
    	ListNode pointer = dummy;
    	
    	while (list1 != null && list2 != null) {
    		if (list1.val <= list2.val) {
    			pointer.next = list1;
    			list1 = list1.next;
    		}
    		else {
    			pointer.next = list2;
    			list2 = list2.next;
    		}
    		pointer = pointer.next;
    	}
    	
    	pointer.next = (list1 == null) ? list2 : list1;
    	
    	return dummy.next;
    }
    
	public static void main(String[] args) {
		ListNode common = new ListNode(40);
		common.next = new ListNode(50);
		
		ListNode node = new ListNode(10);
		node.next = new ListNode(20);
		node.next.next = new ListNode(30);
//		node.next.next.next = common;
		
		ListNode node2 = new ListNode(70);
		node2.next = new ListNode(80);
//		node2.next.next = common;
		
		Util.traverse(node);
		System.out.println();		
		Util.traverse(node2);
		System.out.println();
		
//		ListNode intersectionNode = getIntersectionNode(node, node2);
//		Util.traverse(intersectionNode);

		ListNode merged = mergeTwoLists(node, node2);
		Util.traverse(merged);
	}
}
