package code.ab13_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class St6LC227_BasicCalculatorII {

	public static int calculate(String s) {
        String[] postfix = infixToPostfix(s);
//        System.out.println(Arrays.toString(postfix));
        Stack<Integer> st = new Stack<>();
        for (String c : postfix) {
            if (isOperator(c)) {
                int latest = st.pop();
                int first = st.pop();
                int result = calculate(first, latest, c);
                st.push(result);
            }
            else {
                st.push(Integer.parseInt(c));
            }
        }
        return st.pop();
    }

	public static void main(String[] args) {
//		String in1 = "0-2147483647";
//		String in1 = "42"; 
		String in1 = " 3/2 "; 
		String[] infixToPostfix = infixToPostfix(in1);
		System.out.println(Arrays.toString(infixToPostfix));
		System.out.println(calculate(in1));
		
	}
	
	static String [] infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        List<String> postfix = new ArrayList<String>();
        StringBuilder sb;

        for (int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
            if (c == ' ') continue;
            if (isCharOperator(c)) {
                if (st.isEmpty() || charPrecedence(c) > charPrecedence(st.peek())) {
                    st.push(c);
                }
                else {
                    while (!st.isEmpty() && charPrecedence(c) <= charPrecedence(st.peek())) {
                        char ch = st.pop();
                        postfix.add(String.valueOf(ch));
                    }
                    st.push(c);
                }
            }
            else {
            	sb = new StringBuilder();
//            	while (i<s.length() && !isCharOperator(s.charAt(i))) {
            	while (i<s.length() && Character.isDigit(s.charAt(i))) {
//            		if (s.charAt(i) == ' ') {
//            			i++;
//            			continue;
//            		}
            		sb.append(s.charAt(i));
            		i++;
            	}
            	postfix.add(sb.toString());
            	i--;
            }
        }

        while (!st.isEmpty()) {
        	postfix.add(String.valueOf(st.pop()));
        }
        return postfix.toArray(new String[0]);
    }

	static boolean isCharOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
	static int calculateWithChar(int a, int b, char operator) {
        if (operator == '+')    return a + b;
        if (operator == '-')    return a - b;
        if (operator == '*')    return a * b;
        if (operator == '/')    return a / b;
        return 0;
    }
	static int charPrecedence(char operator) {
        if (operator == '+' || operator == '-')
            return 1;
        if (operator == '*' || operator == '/')
            return 2;
        return 0;
    }
	
	static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }
	static int calculate(int a, int b, String operator) {
        if (operator.equals("+"))    return a + b;
        if (operator.equals("-"))    return a - b;
        if (operator.equals("*"))    return a * b;
        if (operator.equals("/"))    return a / b;
        return 0;
    }
	static int precedence(String operator) {
        if (operator.equals("+") || operator.equals("-"))
            return 1;
        if (operator.equals("*") || operator.equals("/"))
            return 2;
        return 0;
    }
	
}
