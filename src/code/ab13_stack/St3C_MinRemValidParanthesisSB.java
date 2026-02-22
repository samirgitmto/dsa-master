package code.ab13_stack;

import java.util.Stack;

public class St3C_MinRemValidParanthesisSB {

	static String minRemoveToMakeValidSb(String s) {
		StringBuilder sb = new StringBuilder();
		int openCount = 0;
		// Left to Right pass
		for (Character c : s.toCharArray()) {
			if (c == '(') {
				sb.append(c);
				openCount++;
			}
			else if (c == ')') {
				if (openCount > 0) {
					sb.append(c);
					openCount--;
				}
			}
			else {
				sb.append(c);
			}
		}
		// Right to Left - to remove extra '('
		if (openCount > 0) {
			for (int i=sb.length()-1; i>=0; i--) {
				if (sb.charAt(i) == '(' && openCount > 0) {
					sb.deleteCharAt(i);
					openCount--;
				}
			}
		}
		return sb.toString();
	}
	
	static String minRemoveToMakeValid(String s) {
		Stack<Integer> stackOfOpen = new Stack<Integer>();
		
		char[] arr = s.toCharArray();
		for (int i=0; i < s.length(); i++) {
			if (arr[i] == '(') {
				stackOfOpen.push(i);
			}
			else if (arr[i] == ')') {
				if (stackOfOpen.isEmpty()) {
					arr[i] = '#';
				}
				else {
					stackOfOpen.pop();
				}
			}
		}
		while (!stackOfOpen.isEmpty()) {
			arr[stackOfOpen.pop()] = '#';
		}
		String str = new String(arr);
		// replaceAll uses regex and is slightly slower. Can avoid it by building with a loop:
		String res = str.replaceAll("#", "");
		return res;
	}
	
	public static void main(String[] args) {
//		String in1 = "a)bc(d)";
//		String in1 = "lee(t(c)o)de)";
		String in1 = "))((";
		System.out.println(minRemoveToMakeValid(in1));
	}
	
}