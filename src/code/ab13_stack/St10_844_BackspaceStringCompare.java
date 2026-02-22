package code.ab13_stack;

import java.util.Stack;

public class St10_844_BackspaceStringCompare {
	/**
	 * Input: s = "ab##", t = "c#d#"
	 * Output: true
	 * Explanation: Both s and t become "".
	 * @param s
	 * @param t
	 * @return true if both are equal
	 */
	static boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<Character>();
        Stack<Character> st2 = new Stack<Character>();
        
        for (Character c1 : s.toCharArray()) {
			if (c1 == '#') {
				if (!st1.isEmpty())
					st1.pop();
			}
			else {
				st1.push(c1);
			}
		}
        for (Character c2 : t.toCharArray()) {
			if (c2 == '#') {
				if (!st2.isEmpty())
					st2.pop();
			}
			else {
				st2.push(c2);
			}
		}
        
        if (st1.size() == st2.size()) {
        	while (!st1.isEmpty()) {
				if (st1.pop() != st2.pop())
					return false;
			}
        }
        else
        	return false;
        
        return true;
    }
	
	public static void main(String[] args) {
		String s = "ab##", t = "c#d#";
		System.err.println(backspaceCompare(s, t));
	}
}
