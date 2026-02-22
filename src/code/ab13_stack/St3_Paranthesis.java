package code.ab13_stack;

import java.util.Stack;

public class St3_Paranthesis {

	static boolean isBalanced(String str) {
		char[] cs = str.toCharArray();
		Stack<Character> st = new Stack<Character>();
		
		for (int i = 0; i < cs.length; i++) {
			if (cs[i]=='(') {
				st.push(cs[i]);
			}
			else if (cs[i]==')') {
				if (st.isEmpty()) {
					return false;
				}
				st.pop();
			}
		}
		
		return st.size()==0;
	}
	
	public static void main(String[] args) {
		String str1 = "(a+b)*(c+d)";
//		String str1 = "(a+b)*c+d)";
		System.out.println(isBalanced(str1));
	}
	
}