package code.ab16_binarysearchtrees.ps;

public class PS10_LC162_PeakElement {

	/**
	 * Simulate a Binary Tree and the peak element will be the one where turn happens.
	 * Going right, the null will indicate the turn
	 * Can also use Binary Search approach to eliminate the half BT traversal part
	 * Binary Search on slope
	 * @param nums  {1, 2, 3, 1}
	 * @return     index - 2
	 */
	static int findPeakElement(int[] nums) {
        if (nums == null)	return -1;
        
        int l = 0, r = nums.length - 1;
        
        while (l < r) {
        	int mid = l + (r - l) / 2;
        	
        	if (nums[mid] < nums[mid+1]) {
        		l = mid + 1;
        	}
        	else {
        		r = mid;
        	}
        }
        
        return l;
    }
	
	/**
	 * LC 852
	 * @param arr
	 * @return
	 */
	static int peakIndexInMountainArray(int[] arr) {
        if (arr == null)	return -1;
        
        int l = 0, r = arr.length - 1;
        
        while (l < r) {
        	int mid = l + (r - l) / 2;
        	
        	if (arr[mid] < arr[mid+1]) {
        		l = mid + 1;
        	}
        	else {
        		r = mid;
        	}
        }
        return l;
    }
	
	public static void main(String[] args) {
		int [] arr = {1,2,1,3,5,6,4};
		System.err.println(findPeakElement(arr));
	}
	
}
