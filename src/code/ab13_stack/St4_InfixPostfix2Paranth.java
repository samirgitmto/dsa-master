package code.ab13_stack;

import java.util.Stack;

public class St4_InfixPostfix2Paranth {

	static String getPostfixFromInfix(String in) {
		
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for (Character c : in.toCharArray()) {
			if (isOperator(c)) {
				if (c == ')') {
					while (st.peek() != '(') {
						sb.append(st.pop());
					}
					st.pop();
					continue;
				}
				if (st.isEmpty()) {
					st.push(c);
				}
				else {
					if (c == '(' || getPrecedence(c) > getPrecedence(st.peek())) {
						st.push(c);
					}
					else {
						while (!st.isEmpty() &&
								st.peek() != '(' &&
								getPrecedence(st.peek()) >= getPrecedence(c)) {
							char pop = st.pop();
							sb.append(pop);
						}
						st.push(c);
					}
				}
			}
			else {
				sb.append(c);
			}
		}
		
		while (!st.isEmpty()) {
			if (st.peek() == '(') {
				st.pop();
				continue;
			}
			sb.append(st.pop());
		}
		
		return sb.toString();
	}
	
	private static int getPrecedence(Character c) {
		if (c == '+' || c == '-')	return 1;
		if (c == '*' || c == '/')	return 2;
//		if (c == '^')	return 3;	not applicable yet	
		return 0;
	}

	private static boolean isOperator(Character c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
	}

	
	public static void main(String[] args) {
//		String in1 = "a+b*c";
//		System.out.println(getPostfixFromInfix(in1));
//		String in2 = "(a+b)*c";
		String in2 = "(a+b*c";
		System.out.println(getPostfixFromInfix(in2));
	}
	
}
