package code.ab14_queue;

import java.util.Stack;

public class Q6_DoubleStackQueue {
	Stack<Integer> stack1, stack2;
	public Q6_DoubleStackQueue() {
		this.stack1 = new Stack<Integer>();
		this.stack2 = new Stack<Integer>();
	}
	// insertAtRear
	void enqueue(int x) {
		stack1.push(x);
	}
	// deleteAtFront
	void dequeue() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			System.err.println("queue is empty");
			return;
		}
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		stack2.pop();
	}
	void traverse() {
		// First, print elements from stack2 (front side, top to bottom)
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.print(stack2.get(i) + " ");
        }
        // Then, print elements still in stack1 (rear side, bottom to top)
        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.get(i) + " ");
        }
		System.out.println();
	}
	
	public static void main(String[] args) {
		Q6_DoubleStackQueue queue = new Q6_DoubleStackQueue();
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