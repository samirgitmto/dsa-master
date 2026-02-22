package code.ab14_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q1_JavaQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		System.out.println(queue);
		System.err.println(queue.poll());
		System.out.println(queue);
	}
}