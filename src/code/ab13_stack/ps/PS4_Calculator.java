package code.ab13_stack.ps;

import java.util.Stack;

/**
 * @since 14-04-2026
 */
public class PS4_Calculator {

	/**
	 * Leetcode 224
	 * ( 10 -(4+7) +3)
	 * pushing in the stack on encountering '('.
	 * evaluating result using the prev sign on encountering a sign.
	 * evaluating result on encountering ')' and combining the prevResult.
	 * This is a one-pass solution.
	 * Stack is used only for context switching across parentheses.
	 * No re-processing of characters
	 * @param s
	 * @return
	 */
	static int calculate(String s) {
		
//		int result=0, num=0;
		long result=0, num=0;
		long sign = +1;
		Stack<Long> resultStack = new Stack<Long>();
		
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			// push result & sign and reset result=0
			if (c == '(') {
				resultStack.push(result);
				resultStack.push(sign);
				result = 0;
				sign = +1;
			}
			// apply - pop - combine - reset num
			else if (c == ')') {
				result = result + (sign * num);
				
				sign = resultStack.pop();
				long prevResult = resultStack.pop();
				
				result = prevResult + (sign * result);
				
				num = 0;
			}
			// eval using prevSign - update Sign - reset num=0
			else if (c == '+') {
				result = result + (sign * num);
				sign = +1;
				num = 0;
			}
			else if (c == '-') {
				result = result + (sign * num);
				sign = -1;
				num = 0;
			}
			else {
				if (c == ' ')	continue;
				StringBuilder sb = new StringBuilder();
				while (i < charArray.length && Character.isDigit(charArray[i])) {
					sb.append(charArray[i]);         // can be replaced with number evaluation from the chars
					// num = num * 10 + (c - '0');
					i++;
				}
				num = Long.parseLong(sb.toString());
				
				i--;
			}
		}
		
		return (int) (result + (sign * num));
	}
	
	public static void main(String[] args) {
		String s = "( 10 -(4+7) +3)";
		System.out.println(calculate(s));
		s = "( 10 -(4+7) -3)";
		System.out.println(calculate(s));
		s = "1 + 1";
		System.out.println(calculate(s));
		s = "1-(     -2)";
		System.out.println(calculate(s));
		
		System.out.println(Integer.parseInt("-2147483648"));
//		System.out.println(Integer.parseInt("2147483648"));
		s = "-2147483648";
		System.out.println(calculate(s));
	}
}
