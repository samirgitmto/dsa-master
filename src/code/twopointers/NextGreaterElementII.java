package code.twopointers;

import java.util.Arrays;

public class NextGreaterElementII {

	static int nextGreaterElementII(int in) {
		
		String s = in + "";
		
		char[] digits = s.toCharArray();
		
		int dipIndex = -1;
		
		for (int i=digits.length-2; i>=0; i--) {
			if (digits[i] < digits[i+1]) {
				dipIndex = i;
				break;
			}
		}
		
		if (dipIndex == -1)	return -1;
		
		System.err.println("dipIndex: " + dipIndex);
		
		// S2 - next greater digit to right of dip value but it should be the smallest one
		// rightmost greater digit
//		int nextGreaterToDipIndex = -1;
		
		int rightMostGreaterToDipIndex = -1;
		for (int j = digits.length - 1; j > dipIndex; j--) {
		    if (digits[j] > digits[dipIndex]) {
		        rightMostGreaterToDipIndex = j;
		        break; // stop at first greater from RIGHT side
		    }
		}

		
//		int rightMostGreaterToDipIndex = -1;
//		int j = dipIndex + 1;
//		while (j < digits.length) {
//			if (digits[j] > digits[dipIndex]) {
//				if (rightMostGreaterToDipIndex == -1) {
//					rightMostGreaterToDipIndex = j;
//				}
//				else {
//					if (digits[rightMostGreaterToDipIndex] > digits[j]) {
//						rightMostGreaterToDipIndex = j;
//					}
//				}
//			}
//			j++;
//		}
		// pick the smallest digit on the right that is greater than the dip digit.
		
		System.err.println("nextGreaterToDipIndex: " + rightMostGreaterToDipIndex);
		
		// S3 - swap i & j
		char temp = digits[dipIndex];
		digits[dipIndex] = digits[rightMostGreaterToDipIndex];
		digits[rightMostGreaterToDipIndex] = temp;
		
		System.out.println(Arrays.toString(digits));
		
		// S4 - reverse everything after index i i.e. dipIndex
		int left = dipIndex + 1;
		int right = digits.length - 1;
		while (left < right) {
			char temp2 = digits[left];
			digits[left] = digits[right];
			digits[right] = temp2;
			left++;
			right--;
		}
		
		System.out.println(Arrays.toString(digits));
		
		String res = new String(digits);
		
		
		// not accepted on Leetcode.
//		try {
//			return Integer.parseInt(res);
//		} catch (Exception e) {
//			return -1;
//		}
		
		Long long1 = Long.parseLong(res);
		return long1 <= Integer.MAX_VALUE ? long1.intValue() : -1;
	}
	
	public static void main(String[] args) {
//		int i = 123;
//		int i = 132;
//		int i = 21;
//		int i = 2147483486;
		int i = 12_222_333;		// 12_223_233
		System.out.println(nextGreaterElementII(i));
	}
	
}