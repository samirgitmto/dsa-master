package code.ab14_queue;

public class Q3_LinkedListQueue {
	Node front, rear;
	
	// insertAtRear
	void enqueue(int x) {
		// skip restriction part as this impl is for unlimited elements
		if (this.front==null) {
			this.front = this.rear = new Node(x);
		}
		else {
			Node t = new Node(x);
			this.rear.next = t;
			this.rear = t;
		}
	}
	// deleteAtFront
	void dequeue() {
		if (this.front==null) {
			this.rear = null;
			System.err.println("queue is empty");
		}
		else {
			this.front = this.front.next;
		}
	}
	
	void traverse() {
		Node temp = this.front;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Q3_LinkedListQueue queue = new Q3_LinkedListQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.traverse();
		queue.dequeue();
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