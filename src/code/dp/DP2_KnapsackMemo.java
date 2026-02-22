package code.dp;

import java.util.Arrays;

public class DP2_KnapsackMemo {

	static int getMaxProfit(int capacity, int n, int[] profits, int[] weights) {
		int[] profitsArr = new int[profits.length+1];
		System.arraycopy(profits, 0, profitsArr, 1, profits.length);
		int[] wttsArr = new int[weights.length+1];
		System.arraycopy(weights, 0, wttsArr, 1, weights.length);
		
		// n-down    m-right
		// n 		 capacity
		int[][] dp = new int[n+1][capacity+1];
		
		for (int[] is : dp) {
			Arrays.fill(is, -1);
		}
		for (int[] is : dp) {
			System.err.println(Arrays.toString(is));
		}
		
		return helper(capacity, n, profitsArr, wttsArr, dp);
	}
	
	static int count = 0;
	static int cache = 0;
	private static int helper(int capacity, int n, int[] profits, int[] weights, int[][] dp) {
		if (capacity==0 || n==0) {
			dp[n][capacity] = 0;
			return 0;
		}
		if (dp[n][capacity]!=-1) {
//			System.out.println("cached");
			cache++;
			return dp[n][capacity];
		}
		if (capacity>=weights[n]) {
			int exclude = helper(capacity, n-1, profits, weights, dp);
			int include = helper(capacity-weights[n], n-1, profits, weights, dp) + profits[n];
			dp[n][capacity] = Math.max(exclude, include);
		}
		else {
			int exclude = helper(capacity, n-1, profits, weights, dp);
			dp[n][capacity] = exclude;
		}
		count++;
		return dp[n][capacity];
	}


	public static void main(String[] args) {
		int[] profits = {6, 3, 8};
		int[] weights = {1, 2, 1};
//		System.out.println(getMaxProfit(5, 3, profits, weights));
		
//		capacity = 10
		int profits2[] = {5, 3, 8, 4, 5, 3, 2, 9};    // (n = 8 items)
		int weights2[] = {2, 1, 4, 3, 2, 3, 1, 5};
		System.out.println(getMaxProfit(10, 8, profits2, weights2));
		System.out.println("count: " + count);
		System.out.println("cache: " + cache);
//		23
//		count: 55
//		cache: 26
	}
	
}