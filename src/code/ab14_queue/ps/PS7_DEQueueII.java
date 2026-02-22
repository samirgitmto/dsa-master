package code.ab14_queue.ps;

/**
 * Leetcode 641. Design Circular Deque
 * Using doubly ended LinkedList
 * @author Mohammad Samir
 * @since 20-11-2025
 */
public class PS7_DEQueueII {
	
	Node front, rear;
	int size;
	int length;
	
	public PS7_DEQueueII(int k) {
		this.length = k;
		this.size = 0;
	}
	
	public boolean insertFront(int value) {
        if (size != 0 && size == length) {
        	System.err.println("dqueue is full");
        	return false;
        }
        if (front == null) {
        	front = rear = new Node(value);
        	size++;
        	return true;
        }
        Node insert = new Node(value);
        front.prev = insert;
        insert.next = front;
        front = insert;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (size != 0 && size == length) {
        	System.err.println("dqueue is full");
        	return false;
        }
        Node insert = new Node(value);
        if (front == null) {
        	front = rear = insert;
        	size++;
        	return true;
        }
        insert.prev = rear;
        rear.next = insert;
        rear = rear.next;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (front == null) {
        	System.err.println("queue is empty");
        	return false;
        }
        front = front.next;
        if (front != null)
        	front.prev = null;
        else
            rear = null;
        
        size--;
        return true;
    
    }
    
    public boolean deleteLast() {
        if (front == null) {
        	System.err.println("queue is empty");
        	return false;
        }
        rear = rear.prev;
        if (rear != null)
            rear.next = null;
        else
            front = null;
        size--;
        return true;
    }
    public int getFront() {
        return front != null ? front.val : -1;
    }
    
    public int getRear() {
        return front != null ? rear.val : -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == length;
    }
    
    public static void main(String[] args) {
//	["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]	
//	[[3],[1],[2],[3],[4],[],[],[],[4],[]]
    	PS7_DEQueueII deQueueII = new PS7_DEQueueII(5);
    	System.out.println(deQueueII.insertFront(7));
    	System.out.println(deQueueII.insertLast(0));
//    	System.out.println(deQueueII.insertFront(3));
//    	System.out.println(deQueueII.insertFront(4));
//    	System.out.println(deQueueII.getRear());
//    	System.out.println(deQueueII.isFull());
//    	System.out.println(deQueueII.deleteLast());
//    	System.out.println(deQueueII.insertFront(4));
//    	System.out.println(deQueueII.getFront());
    
    }

   
    static class Node {
    	int val;
    	Node prev, next;
    	public Node(int x) {
			this.val = x;
		}
    }
}
