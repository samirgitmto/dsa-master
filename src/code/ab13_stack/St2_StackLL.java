package code.ab13_stack;

public class St2_StackLL {

	public static void main(String[] args) {
		StackLL stackLL = new StackLL();
		stackLL.push(1);
		stackLL.push(2);
		stackLL.push(3);
		stackLL.push(4);
		stackLL.traverse();
//		System.out.println("stackTop: " + stackLL.stackTop());
		System.out.println(stackLL.pop());
//		System.out.println("stackTop: " + stackLL.stackTop());
		stackLL.traverse();
//		System.out.println(stackLL.isEmpty());
	}
	
}

class StackLL {
	Node top;
	public StackLL() {
	}
	void push(int x) {
		Node insert = new Node(x);
		if (top == null) {
			top = insert;
			return;
		}
		insert.next = top;
		top = insert;
	}
	int pop() {
		if (top == null) {
			throw new RuntimeException("empty stack");
		}
		int value = top.val;
		top = top.next;
		return value;
	}
	void traverse() {
		Node current = top;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	static class Node {
		int val;
		Node next;
		public Node(int x) {
			this.val = x;
		}
	}
}


class StackLL0 {
	Node top;
	int push(int x) {
		if (top==null) {
			top = new Node(x);
			return x;
		}
		Node tail = top;
		top = new Node(x);
		top.next = tail;
		return x;
	}
	int pop() {
		if (top==null) {
			System.err.println("empty stack");
			return -1;
		}
		int value = top.value;
		top = top.next;
		return value;
	}
	int stackTop() {
		if (top!=null) {
			return top.value;
		}
		return -1;
	}
	boolean isEmpty() {
		return top==null;
	}
 	void traverse() {
		if (top==null) {
			System.err.println("empty stack");
			return;
		}
		Node current = top;
		while (current!=null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}
}

class Node {
	int value;
	Node next;
	public Node(int x) {
		this.value = x;
	}
}