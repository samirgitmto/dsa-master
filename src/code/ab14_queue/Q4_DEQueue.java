package code.ab14_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q4_DEQueue {

	
	
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.addLast(10);
		deque.addFirst(1);
		deque.add(15);
		System.out.println(deque);		// [1, 10, 15]
		deque.addFirst(-10);
		System.out.println(deque);      // [-10, 1, 10, 15]
		
		List<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		System.err.println(linkedList);
		linkedList.addFirst(40);
		System.out.println(linkedList);
	}
}