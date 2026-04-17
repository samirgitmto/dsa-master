package code.ab14_queue.ps;

import java.util.ArrayDeque;

/**
 * Approach: Use 2 Queues so that the amoritized time complexity remains O(1)
 * Use two ArrayDeque<Integer> instances.
 * @author Mohammad Samir
 * @since 20-11-2025
 * 
 */
public class PS8_LC1670_FrontMiddleBackQueue {
	ArrayDeque<Integer> frontDeque;
	ArrayDeque<Integer> backDeque;
	
	public PS8_LC1670_FrontMiddleBackQueue() {
		this.frontDeque = new ArrayDeque<Integer>();
		this.backDeque = new ArrayDeque<Integer>();
	}
	
	public void pushFront(int val) {
        frontDeque.offerFirst(val);
        rebalance();
    }
    
	// Pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5].
    public void pushMiddle(int val) {
    	if (frontDeque.size() == backDeque.size()+1) {
    		int polled = frontDeque.pollLast();
    		backDeque.offerFirst(polled);
    	}
        frontDeque.offerLast(val);
        rebalance();
    }
    
    public void pushBack(int val) {
        backDeque.offerLast(val);
        rebalance();
    }
    
    public int popFront() {
    	int poppedFront = -1;
    	if (!frontDeque.isEmpty()) {
    		 poppedFront = frontDeque.pollFirst();
    		 // rebalance
    		 rebalance();
    	}
    	
        return poppedFront;
    }

	private void rebalance() {
		if (frontDeque.size() > backDeque.size() + 1 ) {
			 int polledLast = frontDeque.pollLast();
			 backDeque.offerFirst(polledLast);
		 }
		 else if (frontDeque.size() < backDeque.size()) {
			 int polledFirst = backDeque.pollFirst();
			 frontDeque.offerLast(polledFirst);
		 }
	}
    
    public int popMiddle() {
    	int poppedMiddle = -1;
    	if (!frontDeque.isEmpty()) {
    		poppedMiddle = frontDeque.pollLast();
    	}
    	
    	rebalance();
    	
        return poppedMiddle;
    }
    
    public int popBack() {
    	int poppedLast = -1;
    	if (!backDeque.isEmpty()) {
    		poppedLast = backDeque.pollLast();
    	}
    	else if (!frontDeque.isEmpty()) {
    		poppedLast = frontDeque.pollLast();
    	}

    	rebalance();

    	return poppedLast;
    }

    public static void main(String[] args) {
//    	["FrontMiddleBackQueue","pushFront","pushBack","pushMiddle","pushMiddle","popFront","popMiddle","popMiddle","popBack","popFront"]
//    	[[],[1],[2],[3],[4],[],[],[],[],[]]
//    	[null,null,null,null,null,1,4,3,2,-1]  output
//    	[null,null,null,null,null,1,3,4,2,-1]  expected
    	
//    	PS8_LC1670_FrontMiddleBackQueue frontMiddleBackQueue = new PS8_LC1670_FrontMiddleBackQueue();
//    	frontMiddleBackQueue.pushFront(1);
//    	frontMiddleBackQueue.pushBack(2);
//    	frontMiddleBackQueue.pushMiddle(3);
//    	
//    	System.out.println(frontMiddleBackQueue.frontDeque);
//    	System.out.println(frontMiddleBackQueue.backDeque);
//    	
//    	frontMiddleBackQueue.pushMiddle(4);
//    	
//    	System.out.println(frontMiddleBackQueue.frontDeque);
//    	System.out.println(frontMiddleBackQueue.backDeque);
//    	
//    	System.err.println(frontMiddleBackQueue.popFront());
//    	System.out.println(frontMiddleBackQueue.popMiddle());
//    	System.err.println(frontMiddleBackQueue.popMiddle());
    	
    	////
    	FrontMiddleBackQueue q = new FrontMiddleBackQueue();
    	q.pushFront(1);
    	q.pushBack(2);
    	q.pushMiddle(3);
    	System.err.println(q.frontDq);
    	System.err.println(q.backDq);
    	q.pushMiddle(4);
    	System.err.println(q.frontDq);
    	System.err.println(q.backDq);
    	
    	System.err.println(q.popFront());
    	System.err.println(q.frontDq);
    	System.err.println(q.backDq);
    	
    	System.out.println(q.popMiddle());
    	System.err.println(q.popMiddle());
    }
}

/**
 * the main invariant is:
 * the size of frontDq must always be greater by 1 OR equal to backDq.
 * 
 * @since 17-04-2026
 */
class FrontMiddleBackQueue {
	
	ArrayDeque<Integer> frontDq, backDq;

    public FrontMiddleBackQueue() {
        frontDq = new ArrayDeque<Integer>();
        backDq = new ArrayDeque<Integer>();
    }
    
    public void pushFront(int val) {
        frontDq.offerFirst(val);
        rebalance(frontDq, backDq);
    }
    
	// Pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5].
    public void pushMiddle(int val) {
    	if (frontDq.size() == backDq.size() + 1) {
    		backDq.offerFirst(frontDq.pollLast());
    	}
    	
        frontDq.offer(val);
        rebalance(frontDq, backDq);
    }
    
    public void pushBack(int val) {
        backDq.offer(val);
        rebalance(frontDq, backDq);
    }
    
    public int popFront() {
        int poll = -1;
        if (!frontDq.isEmpty()) {
        	poll = frontDq.poll();
        	rebalance(frontDq, backDq);
        }
        return poll;
    }
    
    public int popMiddle() {
        int poll = -1;
        if (!frontDq.isEmpty()) {
        	poll = frontDq.pollLast();
        	rebalance(frontDq, backDq);
        }
        return poll;
    }
    
    public int popBack() {
    	int pollLast = -1;
    	if (!backDq.isEmpty()) {
    		pollLast = backDq.pollLast();
    	}
    	else if (!frontDq.isEmpty()) {
    		pollLast = frontDq.pollLast();
    	}
        rebalance(frontDq, backDq);
        return pollLast;
    }
    
    private void rebalance(ArrayDeque<Integer> frontDq, ArrayDeque<Integer> backDq) {
    	if (backDq.size() > frontDq.size()) {
    		frontDq.offer(backDq.poll());
    	}
    	else if (backDq.size() < frontDq.size() - 1) {
    		backDq.offerFirst(frontDq.pollLast());
    	}
    }
}