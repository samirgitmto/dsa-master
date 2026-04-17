package code.ab14_queue.ps;

import java.util.LinkedList;
import java.util.Queue;

public class PS10_DoubleQueueStack {

	Queue<Integer> q1, q2;

    public PS10_DoubleQueueStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q1.offer(x);
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q2.poll();
    }
    
    public int top() {
        return q2.peek();
    }
    
    public boolean empty() {
        return q2.isEmpty();
    }
}
