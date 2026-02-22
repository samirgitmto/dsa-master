package code.ab13_stack;

public class St1_StackArray {

	public static void main(String[] args) {
		StackArr stack = new StackArr();
//		StackArr stack = new StackArr(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.pushExtra(6);
		stack.traverse();
		stack.pop();
		stack.traverse();
	}
}

class StackArr {
	int[] arr;
	int top;
	public StackArr() {
		this.arr = new int[5];
		this.top = -1;
	}
	public StackArr(int size) {
		this.arr = new int[size];
		this.top = -1;
	}
	
	void push(int x) {
		if (top == arr.length - 1) {
			// prefer throwing RuntimeException or returning status codes
			System.err.println("Stack is full");
			return;
		}
		this.arr[++top] = x;
	}
	// Dynamic resizing (like ArrayList)
	void pushExtra(int x) {
		if (top == arr.length - 1) {
			int[] newArr = new int[this.arr.length*2];
			for (int i=0; i<this.arr.length; i++) {
				newArr[i] = this.arr[i];
			}
			this.arr = newArr;
		}
		this.arr[++top] = x;
	}
	
	int pop() {
		if (top == -1) {
			// prefer throwing RuntimeException or returning status codes
			System.err.println("empty stack");
			return -1;
		}
		return this.arr[top--];
	}
	void traverse() {
		if (top == -1) {
			System.err.println("empty stack");
			return;
		}
		int i = 0;
		while (i <= top) {
			System.out.print(this.arr[i++] + " ");
		}
		System.out.println();
	}
}


class StackArr0 {
	int[] arr;
	int head;
	int tail;
	public StackArr0() {
		this.arr = new int[5];
		this.head = this.tail = -1;
	}
	
	void push(int x) {
		if (tail==-1) {
			tail = 0;
			head=0;
		}
		if (tail<arr.length) {
			arr[tail] = x;
			tail++;
		}
	}
	int pop() {
		if (tail==-1) {
			System.err.println("empty stack");
			return -1;
		}
		if (tail==arr.length) {
			tail = tail-2;
		}
		else {
			tail--;
		}
		return arr[tail+1];
	}
	
	void traverse() {
		for (int i = 0; i < tail; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}