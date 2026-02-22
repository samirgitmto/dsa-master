package code.ab13_stack;

import java.util.Stack;

public class St3B_ValidParanthesis {

	/**
	 * Time Complexity - O(n)
	 * Space Complexity - O(n)
	 * @param s
	 * @return boolean
	 */
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (Character c: s.toCharArray()) {
            if (isOpening(c)) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char popped = stack.pop();
                if (c == ')' && popped != '(')
                    return false;
                else if (c == '}' && popped != '{')
                    return false;
                else if (c == ']' && popped != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
    private boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }
	
}