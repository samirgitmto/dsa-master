package code.ab13_stack;

import java.util.Stack;

public class St7_LC224_BasicCalculatorH {

	static int calculate(String s) {
        Stack<Integer> st = new Stack<Integer>();
		int result = 0, currentNum = 0, sign = +1;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				// push both: result & sign
				st.push(result);
				st.push(sign);
				result = 0;
				sign = +1;
			}
			else if (c == ')') {
				// Apply - Pop - Combine
				result = result + (sign * currentNum);
				
				int prevSign = st.pop();
				int prevResult = st.pop();
				
				result = prevResult + (prevSign * result);
				
				currentNum = 0;   // sign as it is
			}
			else if (Character.isDigit(c)) {
				// build num
				currentNum = (currentNum * 10) + (c - '0');
			}
			else if (c == '+' || c == '-') {
				// Apply - Update - Reset
				result = result + (sign * currentNum);
				if (c == '+')	sign = +1;
				else sign = -1;

				currentNum = 0;
			}
		}
		result += sign * currentNum;		
		return result;
    }
	
	public static void main(String[] args) {
//		String s = "( 10-(4+7)+3)";
//		String s = "1+2";
//		String s = "0-2";
//		String s = "10+0-20";
		String s = "0-(2147483647)";
		System.out.println(calculate(s));
	}
	
}