package code.ab13_stack;

import java.util.Stack;

public class St8_LC394_DecodeString {

	static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder decodedSb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
        	if (c == ']') {
        		StringBuilder sb = new StringBuilder();
        		while (st.peek() != '[') {
        			sb.append(st.pop());
        		}
        		sb.reverse();
        		st.pop();    // '['
        		
        		StringBuilder repetition = new StringBuilder();
        		while (!st.isEmpty() && Character.isDigit(st.peek())) {
        			repetition.append(st.pop());
        		}
        		
        		int multiplier = Integer.parseInt(repetition.reverse().toString());
        		String temp = sb.toString();
        		for (int j=0; j<multiplier-1; j++) {
        			sb.append(temp);
        		}
        		
        		for (char d : sb.toString().toCharArray()) {
        			st.push(d);
        		}
        	}
        	else {
        		st.push(c);
        	}
        }
        
        while (!st.isEmpty()) {
        	decodedSb.append(st.pop());
        }
        
        return decodedSb.reverse().toString();
        
    }
	
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
//		s = "3[a2[c]]";
		s = "10[a]";
		System.out.println(decodeString(s));
	}
}