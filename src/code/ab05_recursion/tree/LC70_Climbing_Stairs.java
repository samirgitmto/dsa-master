package code.ab05_recursion.tree;

import java.util.Arrays;

public class LC70_Climbing_Stairs {

	public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return det(n, memo);
    }

    private int det(int n, int[] memo) {
        if (n<=2) {
            return n;
        }
        if (memo[n]!=-1) {
            return memo[n];
        }
        else {
            memo[n] = det(n-1, memo) + det(n-2, memo);
            return memo[n];
        }
    }
	
}
