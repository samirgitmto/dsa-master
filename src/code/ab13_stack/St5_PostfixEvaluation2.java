package code.ab13_stack;

import java.util.Stack;

public class St5_PostfixEvaluation2 {

	/**
	 * works for single digit only
	 * @param postfix
	 * @return
	 */
	static double evalPostfix(String postfix) {
		Stack<Double> st = new Stack<Double>();
		
		for (Character c : postfix.toCharArray()) {
			if (isOperator(c)) {
				double latest = st.pop();
				double first = st.pop();
				double result = calculate(first, latest, c);
				st.push(result);
			}
			else {
				st.push((double) (c - '0'));
			}
		}
		
		
		return st.pop();
	}
	
	private static double calculate(double a, double b, Character c) {
		if (c == '+')	return a+b;
		if (c == '-')	return a-b;
		if (c == '*')	return a*b;
		if (c == '/')	return a/b;
		return 0;
	}

	private static boolean isOperator(Character c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
	
	public static void main(String[] args) {
		String in1 = "a+b*c";
//		System.out.println(getPostfixFromInfix(in1));
//		String in2 = "(a+b)*c";
//		String in2 = "(a+b*c)";
//		String in2 = "(3+4*5)";
//		String in2 = "(3+4)*5";
		String in2 = "8/4";
		String postfixFromInfix = St4_InfixPostfix2Paranth.getPostfixFromInfix(in2);
		System.out.println(postfixFromInfix);
		
		System.out.println(evalPostfix(postfixFromInfix));
		
		String opr = "+";
		
	}
	
}
