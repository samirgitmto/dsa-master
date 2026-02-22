package code.dc;

public class DC1_BinarySearch {

	// DAC
	static boolean binarySearch(int[] arr, int target, int left, int right) {
		// check if it is small enough
		if (left>right) {
			return false;
		}
		
		// divide
		int mid = left + (right-left)/2;
		// Base case: element found
		if (arr[mid] == target) {
			return true;
		}
		
		// conquer
		if (arr[mid] > target) {
			return binarySearch(arr, target, left, mid-1);
		}
		else {
			return binarySearch(arr, target, mid+1, right);
		}
	
		// Note: No explicit combine step needed for binary search
        // The result from the recursive call is the final result
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(binarySearch(arr, 4, 0, 4));
		System.out.println(binarySearch(arr, 6, 0, 4));
	}
	
}