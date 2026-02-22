package code.ab14_queue.ps;

public class PS1_ArrayQueue {
	int front, rear;
	int[] arr;
	public PS1_ArrayQueue(int size) {
		this.arr = new int[size];
		this.front = -1;
		this.rear = -1;
	}
	
	void insertAtRear(int x) {
		if (rear == -1) {
			rear = front = 0;
		}
		if (rear < arr.length) {
			arr[rear++] = x;
		}
		else {
			System.err.println("queue is full");
		}
	}
	int deleteAtFront() {
		if (front == -1) {
			System.err.println("queue is empty");
			return -1;
		}
		
		int deleted = -1;
		if (front < rear) {
			deleted = arr[front++];
		}
		if (front == rear) {
			front = rear = -1;
			
		}
		return deleted;
	}
	
	void traverse() {
		
		int i = front;
		while (i < rear) {
			System.out.print(arr[i++] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		PS1_ArrayQueue queue = new PS1_ArrayQueue(3);
		queue.insertAtRear(1);
		queue.insertAtRear(2);
		queue.insertAtRear(3);
		queue.insertAtRear(4);
		queue.insertAtRear(5);
		queue.insertAtRear(6);
		queue.traverse();
		
		System.err.println(queue.deleteAtFront());
		queue.traverse();
		System.err.println(queue.deleteAtFront());
		queue.traverse();
		System.err.println("delete: " + queue.deleteAtFront());
		queue.traverse();
		System.out.println("queue.front: " + queue.front);
		System.out.println("queue.rear: " + queue.rear);
		System.err.println("delete2: " + queue.deleteAtFront());
		queue.traverse();
		
		
		queue.insertAtRear(4);
		queue.insertAtRear(5);
		queue.insertAtRear(6);
		queue.traverse();
	}
}
