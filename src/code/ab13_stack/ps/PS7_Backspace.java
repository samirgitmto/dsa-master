package code.ab13_stack.ps;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @since 16-04-2026
 */
public class PS7_Backspace {

	/**
	 * LC 844. undo using stack
	 * @param s
	 * @param t
	 * @return
	 */
	static boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<Character>();
        Stack<Character> st2 = new Stack<Character>();
		
        for (char c : s.toCharArray()) {
        	if (c == '#') {
        		if (!st1.isEmpty())
        			st1.pop();
        	}
        	else {
        		st1.push(c);
        	}
        }
//        st1.stream().collect(Collectors.joining())
        for (char d : t.toCharArray()) {
        	if (d == '#') {
        		if (!st2.isEmpty())
        			st2.pop();
        	}
        	else {
        		st2.push(d);
        	}
        }
		
//        System.err.println(st1);
//        System.err.println(st2);
        
        if (st1.size() == st2.size()) {
        	while (!st1.isEmpty()) {
        		if (st1.pop() != st2.pop()) {
        			return false;
        		}
        	}
        }
        
		return st1.isEmpty() && st2.isEmpty();
    }
	
	public static void main(String[] args) {
		String s = "ab#c", t = "ad#c";
//		System.out.println(backspaceCompare(s, t));
		s = "xywrrmp"; t = "xywrrm#p";
//		System.out.println(backspaceCompare(s, t));
		s = "y#fo##f"; t = "y#f#o##f";
		System.out.println(backspaceCompare(s, t));
		
	}
}
