package code.dp;

import java.util.HashMap;

public class P1_CanEarn {

	static boolean canReach(int[] arr, int target) {
		return helper(arr, target, 0);
	}
	private static boolean helper(int[] arr, int target, int index) {
		if (target==0)
			return true;
		else if (target<0 || index<0)
			return false;
		
		for (int i = index; i < arr.length; i++) {
			if (helper(arr, target-arr[i], index)) {
				return true;
			}
		}
		System.out.println("index: " + index);
		return false;
	}
	
	static boolean canReachMemo(int[] arr, int target) {
		return helperMemo(arr, target, 0, new HashMap<Integer, Boolean>());
	}
	
	
	private static boolean helperMemo(int[] arr, int target, int i, HashMap<Integer, Boolean> hashMap) {
		if (hashMap.containsKey(target)) {
			return hashMap.get(target);
		}
		if (target==0) {
			return true;
		}
		if (target<0 || i<0) {
			return false;
		}
		
		
		for (int j = 0; j < arr.length; j++) {
			if (helperMemo(arr, target-arr[i], i, hashMap)) {
				hashMap.put(target, true);
				return true;
			}
		}
		
		hashMap.put(target, false);
		return false;
	}
	
	static boolean canReachTabulation(int[] arr, int target) {
		boolean[] dp = new boolean[target+1];
		dp[0] = true;
		
		for (int i = 1; i <= target; i++) {
			
			for (int num : arr) {
//				if ()
			}
		}
		
		return dp[target];
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 15, 7};   // 24
		System.out.println(canReach(arr, 24));
//		int[] arr2 = {10, 15, 7, 21, 4, 12};   // 28
//		System.out.println(canReach(arr, 28));
	}
	
}