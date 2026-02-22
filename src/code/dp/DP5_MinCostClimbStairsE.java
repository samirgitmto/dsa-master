package code.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP5_MinCostClimbStairsE {
	/*
		int[] costs = {10, 15, 20};		// ith cost and can start from index 0 or 1;
	// either 1 or 2 steps
* 		start at 0: pay 10
					   1 step: at 15 - pay 15:
					   				          1 step: at 20 - pay 20
					   				          end: total cost = 20 + 15 + 10 = 45
					   2 step: at 20 - pay 20:
					   						  end: total cost = 20 + 10 = 30
	start at 1: pay 15
					   1 step: at 20 - pay 20
					   						 end: total cost = 35
					   2 step: end: total cost = 15 ***
*/
	static int getMinCostToTop(int[] costs) {
		return helper(costs, new Integer[costs.length+1], costs.length);
	}
	
	private static int helper(int[] costs, Integer[] memo, int top) {
		if (top<=1) {
			return 0;
		}
//		if (memo.get)
		int from1stepBack = helper(costs, memo, top-1) + costs[top-1];
		int from2stepBack = helper(costs, memo, top-2) + costs[top-2];
		int min = Math.min(from1stepBack, from2stepBack);
		return min;
	}

	public static void main(String[] args) {
		int[] costs = {10, 15, 20};		// ith cost and can start from index 0 or 1;
		System.out.println(getMinCostToTop(costs));
	}
	
}