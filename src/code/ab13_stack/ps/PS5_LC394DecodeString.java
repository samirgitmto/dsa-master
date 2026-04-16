package code.ab13_stack.ps;

import java.util.Iterator;
import java.util.Stack;

public class PS5_LC394DecodeString {

	/**
	 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
	 *  Note that k is guaranteed to be a positive integer.
	 *  
	 *  Char stack leads to:
	 *  -> reverse handling    -> digit parsing complexity
	 *  BETTER TO USE String + Count stacks
	 * @param s
	 * @return
	 */
	static String decodeString0(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		
		char[] charArray = s.toCharArray();
		
		for (int i = 0; i < s.length(); i++) {
			char c = charArray[i];
			if (c == ']') {
				StringBuilder currentSb = new StringBuilder();
				while (!stack.isEmpty() && stack.peek() != '[') {
					char pop = stack.pop();
					currentSb.append(pop);
				}
//				currentSb.reverse();
				stack.pop();   // pop out '['
				
				// 1 2 --> 21 wrong
				// 1 2 --> 12
				int reps = 0, base = 1;
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					reps = reps + (stack.pop() - '0') * base;
					base *= 10;
				}
				
				StringBuilder sb = new StringBuilder(currentSb.toString());
				for (int j=1; j<reps; j++) {
					currentSb.append(sb);
				}
				
				char[] charArray2 = currentSb.reverse().toString().toCharArray();
				for (int k = 0; k < charArray2.length; k++) {
					stack.push(charArray2[k]);
				}
			}
			else {
				stack.push(charArray[i]);
			}
		}
		
		int size = stack.size();
		char[] finalArr = new char[size];
		for (int l = 0; l < size; l++) {
			finalArr[l] = stack.get(l);
//			finalArr[l] = stack.pop();
		}
		
		return new String(finalArr);
	}
	
	/**
	 * better approach
	 * @param s
	 * @return
	 */
	static String decodeString(String s) {
		
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> stringStack = new Stack<String>();
		int k = 0;
		String current = "";
		
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				k = (10 * k) + (c - '0');
			}
			else if (c == '[') {
				countStack.push(k);
				stringStack.push(current);
				k = 0;
				current = "";
			}
			else if (c == ']') {
				int repeat = countStack.pop();
				String prev = stringStack.pop();
				
				StringBuilder builder = new StringBuilder(prev);
				for (int i = 0; i < repeat; i++) {
					builder.append(current);
				}
				current = builder.toString();
			}
			else {
				current += c;
			}
		}
		
		return current;
	}
	
	public static void main(String[] args) {
		String s = "3[a2[c]]";
		System.out.println(decodeString(s));
		s = "3[a2[bc]]";
		System.out.println(decodeString(s));
	}
	
}
