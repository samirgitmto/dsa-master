package code.dp;

public class DP1_Knapsack {
	static int getMaxProfit(int capacity, int n, int[] profits, int[] weights) {
		int[] profitsArr = new int[profits.length+1];
		System.arraycopy(profits, 0, profitsArr, 1, profits.length);
		int[] wttsArr = new int[weights.length+1];
		System.arraycopy(weights, 0, wttsArr, 1, weights.length);
		return helper(capacity, n, profitsArr, wttsArr);
	}
	private static int helper(int capacity, int n, int[] profits, int[] weights) {
		if (capacity==0 || n==0)
			return 0;
		if (capacity >= weights[n]) {
			int exclude = helper(capacity, n-1, profits, weights);
			int include = helper(capacity-weights[n], n-1, profits, weights) + profits[n];
			return Math.max(exclude, include);
		}
		else {
			int exclude = helper(capacity, n-1, profits, weights);
			return exclude;
		}
	}
	public static void main(String[] args) {
		int[] profits = {6, 3, 8};
		int[] weights = {1, 2, 1};
		System.out.println(getMaxProfit(5, 3, profits, weights));
		
	}
}