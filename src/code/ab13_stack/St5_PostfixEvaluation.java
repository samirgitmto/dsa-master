package code.ab13_stack;

import java.util.Stack;

public class St5_PostfixEvaluation {

	static int evaluatePostfix(String postfix) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		
		for (int i=0; i<postfix.length(); i++) {
			if (isOperand(postfix.charAt(i))) {
				int current = Character.getNumericValue(postfix.charAt(i));
				stack.push(current);
			}
			else {
				int last = stack.pop();
				int first = stack.pop();
				
				result = calculate(first, last, postfix.charAt(i));
				stack.push(result);
			}
			
		}
		
		return result;
	}
	
	static int calculate(int first, int second, char operand) {
		if (operand=='+') {
			return first + second;
		}
		else if (operand=='-') {
			return first - second;
		}
		else if (operand=='*') {
			return first * second;
		}
		else if (operand=='/') {
			return first / second;
		}
		return 0;
	}
	
	static boolean isOperand(Character ch) {
		if (ch=='+' || ch=='-' || ch=='*' || ch=='/')
			return false;
		return true;
	}
	
	public static void main(String[] args) {
//		String str1 = "A+B*C";		// ABC*+
		String pf1 = "354*+";
		System.out.println(evaluatePostfix(pf1));
		
		String str = "abc";
//		System.err.println(str.substring(0, 1));
		char c = '5';
		System.out.println(c - '0');
	}
	
}