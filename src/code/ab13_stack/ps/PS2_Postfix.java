package code.ab13_stack.ps;

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

	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		int evalRPN = evalRPN(tokens);
		System.out.println(evalRPN);
	}
}
