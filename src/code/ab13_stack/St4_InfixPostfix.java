package code.ab13_stack;

import java.util.Stack;

public class St4_InfixPostfix {

	static String infixToPostfix(String str) {
		char[] chars = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		StringBuilder builder = new StringBuilder(str.length());
		
		for (int i = 0; i < chars.length; i++) {
			Character temp = chars[i];
			if (isOperand(temp)) {
				builder.append(temp);
			}
			else {
				if (stack.isEmpty()) {
					stack.push(temp);
					continue;
				}
				Character stackTop = stack.peek();
				if (getPrecedence(temp)>getPrecedence(stackTop)) {
					stack.push(temp);
				}
				else {
					
					while (!stack.isEmpty() && getPrecedence(stack.peek())>=getPrecedence(temp)) {
						builder.append(stack.pop());
					}
					stack.push(temp);
				}
			}
			
		}
		
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		
		return builder.toString();
	}
	
	static boolean isOperand(Character ch) {
		if (ch=='+' || ch=='-' || ch=='*' || ch=='/')
			return false;
		return true;
	}
	static int getPrecedence(Character ch) {
		if (ch=='+' || ch=='-')
			return 1;
		else if (ch=='*' || ch=='/')
			return 2;
		return 0;
	}
	
	public static void main(String[] args) {
		String str1 = "A+B*C";		// ABC*+
		System.out.println(infixToPostfix(str1));
	}
	
}