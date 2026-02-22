package code.ab13_stack;

import java.util.Arrays;
import java.util.Stack;

public class St9_LC71_SimplifyPath {

	/**
	 * Use Deque (ArrayDeque) in real-world code because:
	 * Stack is legacy and synchronized (slower)
	 * ArrayDeque is the standard modern stack
	 */
	static String simplifyPath(String path) {
		String[] tokens = path.split("/");
		System.out.println(Arrays.toString(tokens));
		
		Stack<String> stack = new Stack<String>();
//	    Deque<String> stack = new ArrayDeque<>(); try this also for stack.removeLast() opn
		
		for (String str : tokens) {
			if (str.equals(".") || str.isEmpty()) {
				continue;
			}
			if (str.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			}
			else {
				stack.push(str);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		System.out.println(stack);
		for (String s : stack) {
			if (!s.isEmpty())
				sb.append("/").append(s);
		}
		
		return !sb.toString().isEmpty() ? sb.toString() : "/";
	}
	
	public static void main(String[] args) {
		System.out.println();
		String path = "/home/user/Documents/../Pictures";
		path = "/../";
		path =	 "/home/";
		path =	 "/home//foo/";
		path = "/.../a/../b/c/../d/./";			// "/.../b/d"
		System.err.println(simplifyPath(path));

		path = "/a//b////c/d//././/..";			// "/a/b/c"
		System.err.println(simplifyPath(path));

		path = "/.";			// "/"
		System.err.println(simplifyPath(path));

		path = "/...";		// "/..."
		System.err.println(simplifyPath(path));
		path = "/..hidden";
		System.err.println(simplifyPath(path));
		path = "/hello../world";
		System.err.println(simplifyPath(path));
	}
	
}
