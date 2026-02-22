package code.ab05_recursion.linear;

import java.util.Arrays;

public class Rc5_Fibo {


	// with memorization, time complexity becomes O(n) from O(2^n) 
	public static int getFib(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return calculate(n, memo);
	}
	private static int calculate(int n, int[] memo) {
		if (n<=1) {
			return n;
		}
		if (memo[n]!=-1) {
			return memo[n];
		}
		memo[n] = calculate(n-1, memo) + calculate(n-2, memo);
		return memo[n];
	}
	
	public static void main(String[] args) {
		
	}
	
}