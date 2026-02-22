package code.dp;

import java.util.Arrays;

public class DP3_SquareMatrixM {

	// bottom up - tabulation
	static int getMaxSquareArea(int[][] matrix) {
		int max = 0;
		if (matrix.length==0)
			return max;

//		check prev adjacents - left, up and diagonal
		int[][] dp = new int[matrix.length][matrix[0].length];
		
		for (int i=0; i<dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (matrix[i][j]==0) {
					dp[i][j] = 0;
					continue;
				}
				if (i==0 || j==0) {
					dp[i][j] = matrix[i][j];
				}
				else {
					int top = dp[i-1][j];
					int diag = dp[i-1][j-1];
					int left = dp[i][j-1];
					dp[i][j] = Math.min(Math.min(top, diag), left) + 1;
					
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		for (int[] is : dp) {
			System.err.println(Arrays.toString(is));
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[5][4];
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		for (int[] is : arr) {
			for (int i=0; i<is.length; i++) {
				if (i<2) {
					is[i] = 0;
				}
				else {
					is[i] = 1;
				}
			}
		}
		arr[1][1] = 1;
		arr[2][1] = 1;
		arr[3][1] = 1;
		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
		
		System.err.println(getMaxSquareArea(arr));
		
	}
	
}