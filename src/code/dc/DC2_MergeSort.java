package code.dc;

import java.util.Arrays;

public class DC2_MergeSort {

	// DAC
	static void mergeSort(int[] arr, int l, int r) {
		// if big enough
		if (l>=r) {
			return;
		}
		
		// divide
		int mid = l + (r-l)/2;
		
		// conquer
		mergeSort(arr, l, mid);
		mergeSort(arr, mid+1, r);
		
		// combine
		merge(arr, l, mid, r);
	}
	
	private static void merge(int[] arr, int l, int mid, int r) {
		int[] leftArr = new int[mid-l+1];
		int[] rightArr = new int[r-mid];
		
		System.arraycopy(arr, l, leftArr, 0, leftArr.length);
		System.arraycopy(arr, mid+1, rightArr, 0, rightArr.length);
		
		// merge
		int i=0, j=0, k=l;
		while (i<leftArr.length && j<rightArr.length) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			}
			else {
				arr[k++] = rightArr[j++];
			}
		}
		while (i<leftArr.length) {
			arr[k++] = leftArr[i++];
		}
		while (j<rightArr.length) {
			arr[k++] = rightArr[j++];
		}
	}

	public static void main(String[] args) {
		int[] arr = {4, 1, 2, 5, 3};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
}