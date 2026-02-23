package code.ab13_stack.ps;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

public class PS1_ValidParanthesis {

	/**
	 * LC 20 - valid paranthesis EASY
	 * {[]}
	 * @param s
	 * @return boolean
	 */
    static boolean isValid0(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	for (int i=0; i<s.length(); i++) {
    		if (isOpening(s.charAt(i))) {
    			stack.push(s.charAt(i));
    		}
    		else {
    			if (stack.isEmpty() || !validParanthesis(stack.pop(), s.charAt(i))) {
    				return false;
    			}
    		}
    	}
    	
    	return stack.isEmpty();
    }
	
    private static boolean isOpening(char ch) {
		if (ch == '(' || ch == '{' || ch == '[')
			return true;
		return false;
	}
    private static boolean validParanthesis(char ch1, char ch2) {
		if (ch1 == '(' && ch2 == ')')
			return true;
		else if (ch1 == '{' && ch2 == '}')
			return true;
		else if (ch1 == '[' && ch2 == ']')
			return true;
		return false;
	}
    
    /**
     * Data driven logic instead of conditionals
     * @param s
     * @return
     */
    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );

        for (char ch : s.toCharArray()) {
            if (map.containsValue(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    
    /**
     * LC 1249. Minimum Remove to Make Valid Parentheses
     * @param str
     * @return String
     * 
     * Avoid replaceAll (regex overhead)
     */
    static String minRemoveToMakeValid(String s) {
    	Stack<Integer> stack = new Stack<>();
    	// a(b(c)
    	char[] chars = s.toCharArray();
    	
    	for (int i = 0; i < s.length(); i++) {
    		if (chars[i] == '(') {
    			stack.push(i);
    		}
    		else if (chars[i] == ')') {
    			if (stack.isEmpty())
    				chars[i] = '#';
    			else
    				stack.pop();
    		}
    	}
    	
    	while (!stack.isEmpty()) {
			chars[stack.pop()] = '#';
		}
    	
    	String result = new String(chars);
    	String replaceAll = result.replaceAll("#", "");
    	return replaceAll;
    }
    
    static String minRemoveToMakeValidII(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    chars[i] = '#';
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            chars[stack.pop()] = '#';
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '#') sb.append(c);
        }

        return sb.toString();
    }
    
	public static void main(String[] args) {
		System.out.println(isValid("({[]})"));
		System.out.println(isValid("({[})"));
		String s1 = "l(e(e(t(c)ode";
		System.out.println(minRemoveToMakeValid(s1));
	}
}
