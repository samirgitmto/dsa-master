package code.ab14_queue.ps;

public class PS3_LinkedListQueue {
	Node front, rear;
	private int size;
	public PS3_LinkedListQueue() {
		this.front = this.rear = null;
		this.size = 0;
	}
	
	void insertAtRear(int x) {
		if (rear == null) {
			this.front = this.rear = new Node(x);
			size++;
			return;
		}
		rear.next = new Node(x);
		rear = rear.next;
		size++;
	}
	int deleteAtFront() {
		if (front == null) {
			System.err.println("empty queue");
			return -1;
		}
		int deleted = front.val;
		front = front.next;
		size--;
		if (front == null)
			rear = null;
		return deleted;
	}
	int size() {
		return this.size;
	}
	void traverse() {
		if (front == null) {
			System.err.println("empty queue");
			return;
		}
		Node temp = front;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PS3_LinkedListQueue queue = new PS3_LinkedListQueue();
		queue.insertAtRear(1);
		queue.insertAtRear(2);
		queue.insertAtRear(3);
		queue.insertAtRear(4);
		queue.traverse();
		queue.deleteAtFront();
		queue.traverse();
		queue.insertAtRear(5);
		queue.traverse();
		queue.insertAtRear(10);
		queue.traverse();
	}
	
}

class Node {
	int val;
	Node next;
	public Node(int x) {
		this.val = x;
	}
}