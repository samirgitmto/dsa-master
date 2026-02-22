package code.binarysearch;

public class PS01_LC162_FindPeakElement {

	/**
	 * using Binary Search
	 * Complexity: Time O(log N)
	 * 
	 * @param nums
	 * @return peak element
	 */
	static int findPeakElement(int[] nums) {
		if (nums.length < 2)	return nums[0];
		
		int left = 0, right = nums.length - 1;
		
		while (left < right) {
			int mid = left + (right - left)/2;
			
			if (nums[mid] < nums[mid+1]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		
		return left;
    }
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 5, 3, 2};
		System.out.println(findPeakElement(arr));
	}
}