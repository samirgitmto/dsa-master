package code.greedy;

import java.util.Arrays;
import java.util.Random;

public class G1_Knapsack {

	public static void main(String[] args) {
//		int[][] boxTypes = { {1, 3}, {2, 2}, {3, 1} };
		int[][] boxTypes = { {3, 1}, {2, 2}, {3, 3}, {1, 3} };
		
        // Sort by units per box (column index 1) in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        // Print sorted array
        for (int[] box : boxTypes) {
            System.out.println(Arrays.toString(box));
        }
        
        double[][] arr1 = new double[3][4];
        System.err.println(arr1.length);
        for (int i = 0; i < arr1[0].length; i++) {
			Random random = new Random();
			arr1[0][i] = random.nextInt(4, 20);
		}
        System.err.println(Arrays.toString(arr1[0]));
        Arrays.fill(arr1[1], 2);
        
        for (int i = 0; i < arr1[0].length; i++) {
			double ratio = arr1[0][i]/arr1[1][i];
			arr1[2][i] = ratio;
		}
        
        for (double[] is : arr1) {
			System.out.println(Arrays.toString(is));
		}
        // this won't work
//        Arrays.sort(arr1, (arr1[2][a], arr1[2][b]) -> arr1[2][b] - arr1[2][a]);
        
        // need to transpose
        double[][] arr2 = transpose(arr1);
        for (double[] is : arr2) {
			System.out.println(Arrays.toString(is));
		}
	}
	public static double[][] transpose(double[][] matrix) {
	    int rows = matrix.length;
	    int cols = matrix[0].length;
	    double[][] result = new double[cols][rows];
	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[j][i] = matrix[i][j];
	        }
	    }
	    return result;
	}
}