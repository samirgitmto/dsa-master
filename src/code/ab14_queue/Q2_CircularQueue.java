package code.ab14_queue;

public class Q2_CircularQueue {

	int size;
	int front, rear;
	int[] arr;
	public Q2_CircularQueue(int size) {
		this.size = size;
		this.arr = new int[this.size];
	}
	
	// enqueue
	int insertAtRear(int x) {
		int nextRear = (this.rear+1) % this.size;
		if (nextRear==this.front) {
			System.err.println("queue is full");
			return -1;
		}
		this.arr[nextRear] = x;
		this.rear = nextRear;
		return x;
	}
	// dequeue
	int deleteAtFront() {
		if (this.front==this.rear) {
			System.err.println("queue is empty");
			return -1;
		}
		int nextFront = (this.front+1) % this.size;
		this.front = nextFront;
		return this.arr[nextFront];
 	}

	void traverse() {
		int nextFront = (this.front + 1) % this.size;
		int lastRear = (this.rear+1) % this.size;
		for (int i=nextFront; i!=lastRear; i=(i+1)%this.size) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Q2_CircularQueue queue = new Q2_CircularQueue(5);
		queue.insertAtRear(1);
		queue.insertAtRear(2);
		queue.insertAtRear(3);
		queue.insertAtRear(4);
		queue.traverse();
		queue.deleteAtFront();
		queue.traverse();
		queue.insertAtRear(5);
		queue.traverse();
		
		queue.deleteAtFront();
		queue.insertAtRear(10);
		queue.traverse();
	}

}
