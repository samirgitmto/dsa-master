package code.ab14_queue;

public class Q1_ArrayQueue {

	int size;
	int front;
	int rear;
	int[] arr;
	public Q1_ArrayQueue(int size) {
		this.size = size;
		this.arr = new int[this.size];
		this.rear = this.front = -1;
	}
	// enqueue
	int insertAtRear(int x) {
		if (this.rear == this.size-1) {
			System.err.println("queue is full");
			return -1;
		}
		this.arr[++this.rear] = x;
		return x;
	}
	// dequeue
	int deleteAtFront() {
		if (this.front==this.rear) {
			System.err.println("queue is empty");
			return -1;
		}
		this.front++;
		return this.arr[this.front];
	}
	void traverse() {
		for (int i=front+1; i<=rear; i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Q1_ArrayQueue queue = new Q1_ArrayQueue(5);
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
	}
}
