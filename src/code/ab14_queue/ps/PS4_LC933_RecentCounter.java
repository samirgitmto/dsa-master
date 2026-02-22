package code.ab14_queue.ps;

import java.util.LinkedList;
import java.util.Queue;

public class PS4_LC933_RecentCounter {
	Queue<Integer> queue;
    
	public PS4_LC933_RecentCounter() {
        this.queue = new LinkedList<Integer>();
    }

    public int ping(int t) {
        if (queue.isEmpty()) {
        	queue.add(t);
        	return queue.size();
        }
        int left = t - 3000;
        while (queue.isEmpty() && queue.peek() < left) {
        	queue.poll();
        }
        queue.add(t);
        return queue.size();
    }
	
	public static void main(String[] args) {
		
	}
}
