package code.ab14_queue.ps;

public class PS2_CircularQueue {
	int front, rear, size;
	int [] arr;
	
	public PS2_CircularQueue(int length) {
		this.size = length;
		this.arr = new int[size];
		this.front = this.rear = 0;
	}
	
	void insertAtRear(int x) {
		int nextRear = (rear + 1) % size;
		if (front == nextRear) {
			System.err.println("queue is full");
			return;
		}
		arr[nextRear] = x;
		rear = nextRear;
	}
	int deleteAtFront() {
		if (front == rear) {
			System.err.println("empty queue");
			return -1;
		}
		int nextFront = (front + 1) % size;
		int deleted = arr[nextFront];
		front = nextFront;
		return deleted;
	}
	void traverse() {
		if (front == rear) {
			System.err.println("empty queue");
			return;
		}
		int i = front;
		while (i != rear) {
			i = (i + 1) % size;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws InterruptedException {
		PS2_CircularQueue cQueue = new PS2_CircularQueue(3);
		cQueue.insertAtRear(1);
		cQueue.insertAtRear(2);
		cQueue.insertAtRear(3);
//		cQueue.traverse();
		
		cQueue.deleteAtFront();
		cQueue.deleteAtFront();
		cQueue.deleteAtFront();
		cQueue.deleteAtFront();
		System.out.println(cQueue.front);
		cQueue.traverse();
//		cQueue.deleteAtFront();
//		cQueue.traverse();
		
//		cQueue.insertAtRear(2);
//		cQueue.insertAtRear(3);
//		cQueue.traverse();
	}
	
}
