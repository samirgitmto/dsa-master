package code.ab13_stack.ps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Intuition guides the algorithm; invariants prove it correct.
 * Intuition: “We use a monotonic stack because we want the next greater element to the right.”
 * Invariant: “At any point, the stack contains indices of elements in strictly decreasing order whose next greater element has not yet been found.”
 * 
 * LC155: You must implement a solution with O(1) time complexity for each function.
 * Monotonic Invariant
 * Do not mutate a data structure inside a predicate that reasons about its state.
 */
public class PS3_MonotonicStack {

	Stack<Integer> st1;
	Stack<Integer> minStack;
	
    public PS3_MonotonicStack() {
        st1 = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
    	if (minStack.isEmpty() || val <= minStack.peek()) {
    		minStack.push(val);
    	}
        st1.push(val);
    }
    
    /**
     * Never mutate a data structure inside a condition that also depends on its state.
     */
    public void pop() {
        int removed = st1.pop();
        if (minStack.peek() == removed) {
        // if (minStack.peek() == st1.pop().intValue()) {
        	minStack.pop();
        }
    }
    
    public int top() {
        return st1.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
    
    /**
     * LC739. Daily Temperatures (next warmer)
     * @param temperatures
     * @return array
     * Input: temperatures = [73,74,75,71,69,72,76,73]
     * 				Output = [1, 1, 4, 2, 1, 1, 0, 0]
     */
    static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monotonicStack = new Stack<Integer>();

        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
        	if (monotonicStack.isEmpty() || temperatures[i] <= temperatures[monotonicStack.peek().intValue()]) {
				monotonicStack.push(i);
			}
			else {
				while (!monotonicStack.isEmpty() && temperatures[i] > temperatures[monotonicStack.peek().intValue()]) {
					int idx = monotonicStack.pop();
					result[idx] = i - idx;
				}
				monotonicStack.push(i);
			}
		}
        
        while (!monotonicStack.isEmpty()) {
        	result[monotonicStack.pop().intValue()] = 0;
        }
        return result;
    }
    
    
    /**
     * LC496. Next Greater Element
     * @param nums1
     * @param nums2
     * @return array
     * 
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * Output: [-1,3,-1]
     */
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums2.length, 1.0f);
    	Stack<Integer> monotonicStack = new Stack<Integer>();
        for (int n : nums2) {
        	if (monotonicStack.isEmpty() || n <= monotonicStack.peek().intValue()) {
        		monotonicStack.push(n);
        	}
        	else {
        		while (!monotonicStack.isEmpty() && n > monotonicStack.peek().intValue()) {
        			map.put(monotonicStack.pop().intValue(), n);
        		}
        		monotonicStack.push(n);
        	}
    	}
        
        while (!monotonicStack.isEmpty()) {
        	map.put(monotonicStack.pop().intValue(), -1);
		}
        int[] result = new int[nums1.length];
        int j = 0;
        
        for (int i : nums1) {
        	result[j++] = map.get(i);
        }
        return result;
    }
    
    
    /**
     * LC503. Next Greater Element II (circular array)
     * We can iterate twice on the input array
     * Circularity means each element can see at most n−1 future elements
     * @param nums
     * @return array
     * Input:  [1,2,1]       [1,1,2]
     * Output: [2,-1,2]      [2,2,-1]
     */
    static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> monotonicStack = new Stack<Integer>();
        int[] result = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
        	if (monotonicStack.isEmpty() || nums[i] <= nums[monotonicStack.peek().intValue()]) {
        		monotonicStack.push(i);
        	}
        	else {
        		while (!monotonicStack.isEmpty() && nums[i] > nums[monotonicStack.peek()]) {
        			int idx = monotonicStack.pop();
        			result[idx] = nums[i];
        		}
        		monotonicStack.push(i);
        	}
        }
        
        for (int j=0; j<nums.length; j++) {
        	while (!monotonicStack.isEmpty() && nums[j] > nums[monotonicStack.peek()]) {
        		int idx = monotonicStack.pop();
    			result[idx] = nums[j];
        	}
        }
        
        while (!monotonicStack.isEmpty()) {
        	result[monotonicStack.pop()] = -1;
        }
        return result;
    }
    
    /**
     * LC556. Next Greater Element III
     * *** 2-Pointer - classic Next Permutation problem
     * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n 
     *  and is greater in value than n. If no such positive integer exists, return -1.
     * @param n
     * @return i
     * 
     * Input: n = 12 Output: 21
     * Input: n = 21 Output: -1
     * Input: n = 21453 Output: 21534     dip=4 --> swap = 543 ---> rev = 34
     * Reversed after pivot bcoz that is the largest value and we have to get the smallest suffix as we have already determined the minimal largest prefix.
     * Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
     */
    static int nextGreaterElement(int n) {
    	
    	String in = String.valueOf(n);
    	int dipIndex = -1;
    	
    	for (int i = in.length()-2; i>=0; i--) {
    		if (Character.getNumericValue(in.charAt(i)) < Character.getNumericValue(in.charAt(i+1))) {
    			dipIndex = i;
    			break;
    		}
    	}
    	if (dipIndex == -1)	return -1;
    	
    	char[] chars = in.toCharArray();
    	int nextMostGreaterToDip = -1;
    	for (int i=chars.length-1; i>=dipIndex; i--) {
    		if (chars[i] > chars[dipIndex]) {
    			nextMostGreaterToDip = i;
    			break;
    		}
    	}
    	
    	char temp = chars[dipIndex];
    	chars[dipIndex] = chars[nextMostGreaterToDip];
    	chars[nextMostGreaterToDip] = temp;
    	
    	// reverse after dipIndex to get the smallest tail
    	int l=dipIndex+1, r=chars.length-1;
    	while (l<r) {
    		char cur = chars[l];
    		chars[l] = chars[r];
    		chars[r] = cur;
    		l++;
    		r--;
    	}
    	
    	String result = new String(chars);
    	
    	return Long.parseLong(result) > Integer.MAX_VALUE ? -1 : Integer.parseInt(result);
    }
    
    public static void main(String[] args) {
		int [] temperatures = {73,74,75,71,69,72,76,73};
		int[] dailyTemperatures = dailyTemperatures(temperatures);
		System.out.println(Arrays.toString(dailyTemperatures));
		
		int [] nums1 = {4,1,2}, nums2 = {1,3,4,2};
		int[] nextGreaterElement = nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.toString(nextGreaterElement));
		
//		int[] nums = {1, 2, 1};
		int[] nums = {1, 1, 2};
		int[] nextGreaterElements = nextGreaterElements(nums);
		System.out.println(Arrays.toString(nextGreaterElements));
		
		System.out.println(nextGreaterElement(21453));
	}
}
