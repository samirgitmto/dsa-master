package code.ab14_queue.ps;

import java.util.ArrayDeque;

/**
 * Approach: Use 2 Queues so that the amoritized time complexity remains O(1)
 * Use two ArrayDeque<Integer> instances.
 * @author Mohammad Samir
 * @since 20-11-2025
 * 
 */
public class PS8_LC1670_FrontMiddleBackQueueV1 {
	ArrayDeque<Integer> frontDeque;
	ArrayDeque<Integer> backDeque;
	
	public PS8_LC1670_FrontMiddleBackQueueV1() {
		this.frontDeque = new ArrayDeque<Integer>();
		this.backDeque = new ArrayDeque<Integer>();
	}
	
	public void pushFront(int val) {
        if (frontDeque.size() == backDeque.size()) {
        	frontDeque.offerFirst(val);
        }
        else {
        	int polledLast = frontDeque.pollLast();
        	backDeque.offerFirst(polledLast);
        	frontDeque.offerFirst(val);
        }
    }
    
    public void pushMiddle(int val) {
        if (frontDeque.size() == backDeque.size()) {
        	frontDeque.offerLast(val);
        }
        else {
        	backDeque.offerFirst(val);
        }
    }
    
    public void pushBack(int val) {
        if (frontDeque.size() == backDeque.size()) {
        	// null check
        	if (!backDeque.isEmpty()) {
        		int polledFirst = backDeque.pollFirst();
            	frontDeque.offerLast(polledFirst);
        	}
        	backDeque.offerLast(val);
        }
        else {
        	backDeque.offerLast(val);
        }
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
    		if (frontDeque.size() == backDeque.size()) {
        		poppedMiddle = backDeque.pollFirst();
    		}
    		else if (frontDeque.size() == backDeque.size()+1) {
    			poppedMiddle = frontDeque.pollLast();
    		}

    		rebalance();
    	}
    	
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
	
}