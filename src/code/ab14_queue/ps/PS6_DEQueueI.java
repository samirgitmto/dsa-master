package code.ab14_queue.ps;

/**
 * addFirst(), addLast()
 * removeFirst(), removeLast()
 * peekFirst(), peekLast()
 * Real-world: Browsers, caching systems (LRU), sliding window max, monotonic queues.
 * @since 20-11-2025
 */
public class PS6_DEQueueI {
	int front, rear;
	int[] arr;
	int size;
	public PS6_DEQueueI(int length) {
		this.size = length;
		this.arr = new int[size];
	}
	
	/**
	 * enhancement
	 */
	void addFirst(int x) {
		int prevFront = ((front - 1) + size) % size;
		if (prevFront == rear) {
			System.err.println("queue is full");
			return;
		}
		arr[front] = x;
		front = prevFront;
	}
	/**
	 * default behaviour of Queue
	 */
	void addLast(int x) {
		int nextRear = (rear + 1) % size;
		if (nextRear == front) {
			System.err.println("queue is full");
			return;
		}
		arr[nextRear] = x;
		rear = nextRear;
	}
	/**
	 * default behaviour
	 * @return polled element
	 */
	int removeFirst() {
		if (front == rear) {
			System.err.println("queue is empty");
			return -1;
		}
		int nextFront = (front + 1) % size;
		int polled = arr[nextFront];
		front = nextFront;
		return polled;
	}
	/**
	 * enhancement
	 * @return polled element
	 */
	int removeLast() {
		if (rear == front) {
			System.err.println("queue is empty");
			return -1;
		}
		int prevRear = ((rear - 1) + size) % size;
		int polled = arr[rear];
		rear = prevRear;
		return polled;
	}
	void traverse() {
		if (front == rear) {
			System.out.println("queue is empty");
			return;
		}
		int i = front;
		while (i != rear) {
			i = (i + 1) % size;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PS6_DEQueueI dq = new PS6_DEQueueI(5);
		dq.addFirst(10);
		dq.addFirst(20);
		dq.addFirst(30);
		dq.traverse();

		/*
		deQueue.addLast(1);
		deQueue.addLast(2);
		deQueue.addLast(3);
		deQueue.addFirst(9);
		deQueue.traverse();     // 9 1 2 3 
		System.err.println(deQueue.front);   // 4
		
		System.out.println(deQueue.removeLast());   // 3
		deQueue.traverse();   // 9 1 2 
		System.err.println(deQueue.front);   // 4
		*/
	}
}
