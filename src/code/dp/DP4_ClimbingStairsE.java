package code.dp;

import java.util.HashMap;

public class DP4_ClimbingStairsE {

	static int getWaysCountRec(int n) {
		if (n<=2) {
			return n;
		}
		
		return getWaysCountRec(n-1) + getWaysCountRec(n-2);
	}
	static int getWaysMemoized(int n) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int res = helper(n, hashMap);
		System.out.println(hashMap);
		return res;
	}
	
	private static int helper(int n, HashMap<Integer, Integer> hashMap) {
		if (hashMap.containsKey(n)) {
			return hashMap.get(n);
		}
		if (n<=2) {
//			System.out.println(hashMap);
			hashMap.put(n, n);
			return n;
		}
		
		int res = helper(n-1, hashMap) + helper(n-2, hashMap);
		hashMap.put(n, res);
		return res;
	}
	public static void main(String[] args) {
		int n = 2;
		// either 1 or 2 steps at one time. Determine number of ways to reach the top.
		// n=1 -> (1 step) 1 way
		// n=2 -> (1+1) or (2) 2 ways
		// this can serve as the base case.
		System.out.println(getWaysCountRec(2));
		System.out.println(getWaysMemoized(2));
		System.out.println(getWaysCountRec(3));
		System.out.println(getWaysCountRec(4));
		System.out.println(getWaysCountRec(5));
		System.out.println(getWaysMemoized(5));
		
	}
}