package code.ab14_queue.ps;

import java.util.Arrays;

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
//		PS2_CircularQueue cQueue = new PS2_CircularQueue(3);
//		cQueue.insertAtRear(1);
//		cQueue.insertAtRear(2);
//		cQueue.insertAtRear(3);
//		cQueue.traverse();
		
//		cQueue.deleteAtFront();
//		cQueue.deleteAtFront();
//		cQueue.deleteAtFront();
//		cQueue.deleteAtFront();
//		System.out.println(cQueue.front);
//		cQueue.traverse();
//		cQueue.deleteAtFront();
//		cQueue.traverse();
		
//		cQueue.insertAtRear(2);
//		cQueue.insertAtRear(3);
//		cQueue.traverse();
		
		MyCircularDeque myCircularDeque = new MyCircularDeque(3);
		System.out.println(myCircularDeque.insertLast(1));
		System.out.println(myCircularDeque.insertLast(2));
		System.err.println(myCircularDeque.front);
		System.err.println(myCircularDeque.rear);
		System.out.println(myCircularDeque.insertFront(3));
	}
	
}

/**
 * LC 641
 */
class MyCircularDeque {

	int front, rear, size;
	int [] arr;
	
    public MyCircularDeque(int k) {
        front = rear = 0;
    	size = k+1;
    	arr = new int[size];
    	Arrays.fill(arr, -1);
    }
    
    public boolean insertFront(int value) {
        int prevFront = (front - 1 + size) % size;
        if (prevFront == rear) {
        	System.err.println("Queue is full");
        	return false;
        }
        arr[front] = value;
        front = prevFront;
        return true;
    }
    
    public boolean insertLast(int value) {
    	int nextRear = (rear + 1) % size;
        if (nextRear == front) {
        	System.err.println("Queue is full");
        	return false;
        }
        arr[nextRear] = value;
        rear = nextRear;
        return true;
    }
    
    public boolean deleteFront() {
        if (front == rear) {
        	System.err.println("Queue is empty");
        	return false;
        }
    	int nextFront = (front + 1) % size;
    	arr[nextFront] = -1;
    	front = nextFront;
    	return true;
    }
    
    public boolean deleteLast() {
        if (front == rear) {
        	System.err.println("Queue is empty");
        	return false;
        }
        int prevRear = (rear - 1 + size) % size;
        arr[rear] = -1;
        rear = prevRear;
        return true;
    }
    
    public int getFront() {
        int nextFront = (front + 1) % size;
        return arr[nextFront];
    }
    
    public int getRear() {
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        int nextRear = (rear + 1) % size;
        return front == nextRear;
    }
}
