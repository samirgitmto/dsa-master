package code.ab13_stack.ps;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PS2_Postfix {

	/**
	 * Reverse Polish Notation simply mean for Postfix evaluation
	 * @param tokens
	 * @return int
	 */
	static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String str : tokens) {
        	if (str.length() > 1 || Character.isDigit(str.charAt(0))) {
        		stack.push(Integer.parseInt(str));
			}
			else {
				int op2 = stack.pop();
				int op1 = stack.pop();
				int evaluate = evaluate(op1, op2, str);
				stack.push(evaluate);
			}
		}
        
        return stack.pop();
    }
	
	private static int evaluate(int op1, int op2, String operand) {
		if (operand.equals("+"))	return op1 + op2;
		else if (operand.equals("-"))	return op1 - op2;
		else if (operand.equals("*"))	return op1 * op2;
		else if (operand.equals("/"))	return op1 / op2;
		return 0;
	}

	/**
	 * LC227.Basic Calculator II
	 * TODO provide the optimal solution in O(n) and using a Stack with postfix conversion
	 * @param "3+2*2"
	 * @return 7l
	 */
	static int calculateV1(String s) {
		String [] postfix = infixToPostfix(s);
		
		Stack<Integer> integers = new Stack<Integer>();
		
		for (String str : postfix) {
			if (isOperator(str.charAt(0))) {
				int pop2 = integers.pop();
				int pop1 = integers.pop();
				int evaluate = evaluate(pop1, pop2, str);
				integers.push(evaluate);
			}
			else {
				integers.push(Integer.parseInt(str));
			}
		}
		
		return integers.pop();
    }
	
	/**
	 * Without parenthesis
	 * Use a Stack for Operators and a List for output 
	 * 1. Operands come immediately. 2. Operators come after their operands. (Shunting-Yard Style)
	 * A → output, + → push, B → output, * → higher than + → push, C → output
	 * End: Pop stack → * then +
	 * @param "3+2*2"
	 * @return [3, 2, 2, *, +]
	 */
	private static String [] infixToPostfix(String infix) {
		Stack<Character> operatorStack = new Stack<Character>();
		List<String> postfix = new ArrayList<String>();
		
		for (int i=0; i<infix.length(); i++) {
			char c = infix.charAt(i);
			if (c == ' ')	continue;
			if (isOperator(c)) {
				if (operatorStack.isEmpty()) {
					operatorStack.push(c);
				}
				else {
					while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
						postfix.add(String.valueOf(operatorStack.pop()));
					}
					operatorStack.push(c);
				}
			}
			else {
				StringBuilder sb = new StringBuilder();
				int j=i;
				while (j<infix.length() && !isOperator(infix.charAt(j)) && infix.charAt(j) != ' ') {
					sb.append(infix.charAt(j));
					j++;
				}
				postfix.add(sb.toString());
				i = j - 1;
			}
		}
		
		while (!operatorStack.isEmpty()) {
			postfix.add(String.valueOf(operatorStack.pop()));
		}
		
		return postfix.toArray(new String[0]);
	}
	
	/**
	 * Without parenthesis (Works only for single digits)
	 * Use a Stack for Operators and a List for output 
	 * 1. Operands come immediately. 2. Operators come after their operands. (Shunting-Yard Style)
	 * A → output, + → push, B → output, * → higher than + → push, C → output
	 * End: Pop stack → * then +
	 * @param "3+2*2"
	 * @return [3, 2, 2, *, +]
	 */
	private static String [] infixToPostfixSingleDigits(String infix) {
		Stack<Character> operatorStack = new Stack<Character>();
		List<String> postfix = new ArrayList<String>();
		
		for (char c : infix.toCharArray()) {
			if (c == ' ')	continue;
			if (isOperator(c)) {
				if (operatorStack.isEmpty()) {
					operatorStack.push(c);
				}
				else {
					while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
						postfix.add(String.valueOf(operatorStack.pop()));
					}
					operatorStack.push(c);
				}
			}
			else {
				postfix.add(String.valueOf(c));
			}
		}
		
		while (!operatorStack.isEmpty()) {
			postfix.add(String.valueOf(operatorStack.pop()));
		}
		
		return postfix.toArray(new String[0]);
	}
	
	private static int precedence(char c) {
		if (c == '+' || c == '-')
			return 1;
		if (c == '*' || c == '/')
			return 2;
		return 0;
	}

	private static boolean isOperator(char c) {
		Set<Character> operators = Set.of('+', '-', '*', '/');
		return operators.contains(c);
	}
	
	
	/**
	 * LC227.Basic Calculator II
	 * TODO providing the optimal solution in O(n) and in 1 pass i.e. O(n) & O(1)
	 * num → current number being built from digits 
	 * lastNum → last value that hasn’t been added to result yet
	 * result → running total of finalized numbers 
	 * op → previous operator
	 * If operator or end of string, resolve the previous operator (op)
	 * 3 → lastNum = 3
	 * + → result = 3
	 * 2 → lastNum = 2
	 * * → lastNum = 2 * 2 = 4
	 * end → result + lastNum = 3 + 4 = 7
	 * @param "3+12*2"
	 * @return 27
	 * "0-2147483647"
	 * "1-1"
	 */
	static int calculateV2(String s) {		
		int current=0, lastNum=0, result = 0, prevOpr = '+';
		
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
//			if (c == ' ')	continue;
			if (Character.isDigit(c)) {
				StringBuilder multidigit = new StringBuilder();
				while (i<s.length() && Character.isDigit(s.charAt(i))) {
					multidigit.append(s.charAt(i));
					i++;
				}
				i--;
				current = Integer.parseInt(multidigit.toString());
			}
			if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1) {
				if (prevOpr == '*') {
					lastNum = lastNum * current;
				}
				else if (prevOpr == '/') {
					lastNum = lastNum / current;
				}
				else if (prevOpr == '+') {
					result = result + lastNum;   // at 1- : 0
					lastNum = current;           // 1
				}
				else if (prevOpr == '-') {
					result = result + lastNum; // at 1-1: 1
					lastNum = -current;    // -1
				}
				prevOpr = c;
				current = 0;
			}
		}
		
		result = result + lastNum;
		
		return result;
	}
	
	

	/**
	 * LC224. Basic Calculator (with parenthesis)
	 * @param "(1+(4+5+2)-3)+(6+8)"
	 * @return 23
	 */
	static int calculateII(String s) {
		String[] postfix = getPostfix(s);
		
		Stack<Integer> integers = new Stack<Integer>();
		
		for (String str : postfix) {
			if (isOperator(str.charAt(0))) {
				int pop2 = integers.pop();
				int pop1 = integers.pop();
				int evaluate = evaluate(pop1, pop2, str);
				integers.push(evaluate);
			}
			else {
				integers.push(Integer.parseInt(str));
			}
		}
		
		return integers.pop();
	}
	/**
	 * 
	 * 1. Operands come immediately. 2. Operators come after their operands. (Shunting-Yard Style)
	 * A → output, + → push, B → output, * → higher than + → push, C → output
	 * End: Pop stack → * then +
	 * if ( -> push
	 * if ) -> pop until ( found, add to postfix and discard parenthesis
	 * @return 
	 */
	private static String[] getPostfix(String str) {
		Deque<Character> operatorStack = new ArrayDeque<Character>();
		List<String> output = new ArrayList<String>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ')	continue;
			if (isOperator(c)) {
				if (c == '-' && (i == 0 || str.charAt(i-1) == '(' || isOperator(str.charAt(i-1)))) {
				    output.add("0");
				}
				if (operatorStack.isEmpty()) {
					operatorStack.push(c);
				}
				else {
					while (!operatorStack.isEmpty() && c != '(' && precedence(c) <= precedence(operatorStack.peek())) {
						if (c == '-' && (i == 0 || str.charAt(i-1) == '(' || isOperator(str.charAt(i-1)))) {
						    output.add("0");
						}
						output.add(String.valueOf(operatorStack.pop()));
					}
					operatorStack.push(c);
				}
			}
			else if (c == '(') {
				operatorStack.push(c);
			}
			else if (c == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					if (c == '-' && (i == 0 || str.charAt(i-1) == '(' || isOperator(str.charAt(i-1)))) {
					    output.add("0");
					}
					output.add(String.valueOf(operatorStack.pop()));
				}
				
				operatorStack.pop();
			}
			else {
				StringBuilder multidigit = new StringBuilder();
				while (i<str.length() && Character.isDigit(str.charAt(i))) {
					multidigit.append(str.charAt(i));
					i++;
				}
				output.add(multidigit.toString());
				i--;
			}
		}
		while (!operatorStack.isEmpty()) {
			output.add(String.valueOf(operatorStack.pop()));
		}
		
		return output.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		int evalRPN = evalRPN(tokens);
		System.out.println(evalRPN);
		
		String infix = "3 + 2 * 2";
		System.out.println(Arrays.toString(infixToPostfix(infix)));
		System.out.println(calculateV1(infix));
		System.out.println(calculateV1("42"));
		System.err.println("version 2");
		System.out.println(calculateV2(infix));
		infix = "1-1";
		System.out.println(infix + ": " + calculateV2(infix));
//		infix = "3/2";
		infix = " 3/2 ";
		System.out.println(infix + ": " + calculateV2(infix));
		System.out.println(calculateV2("42"));
		
//		String parenString = "(1+(4+5+2)-3)+(6+8)";
//		String parenString = " 2-1 + 2 ";
		String parenString = "1-(-2)";
		System.err.println(Arrays.toString(getPostfix(parenString)));
		System.out.println(calculateII(parenString));
	}
}
