package code.ab13_stack;

import java.util.Stack;

public class St9_LC71_SimplifyPathV1 {
	// /Documents/..    will be ignored as its the parent directory
    // /a/../b/c/../d   /b/d
	
	static String simplifyPathOld(String path) {
		
		Stack<String> stack = new Stack<>();
		StringBuilder current = new StringBuilder();
		StringBuilder periods = new StringBuilder();
		
		for (Character c : path.toCharArray()) {
			if (c == '/') {
				if (!periods.isEmpty()) {
					if (periods.length() > 2) {
						current.append(periods.toString());
					}
					else if (periods.length() == 2) {
						if (!stack.isEmpty()) {
							stack.pop();
						}
					}
					periods.setLength(0);
				}
				if (!current.isEmpty()) {
					stack.push(current.toString());
					current.setLength(0);
				}
			}
			else if (c == '.') {
				periods.append(c);
			}
			else {
				if (!periods.isEmpty()) {
					current.append(periods);
					periods.setLength(0);
				}
				current.append(c);
			}
		}
		
		if (!periods.isEmpty()) {
			if (periods.length() > 2)
				stack.push(periods.toString());
			else if (periods.length() == 2 && !stack.isEmpty())
				stack.pop();
		}
		
		if (!current.isEmpty()) {
			stack.push(current.toString());
		}
		else {
			if (stack.isEmpty())
				return "/";			
		}
		System.out.println(stack);
		StringBuilder res = new StringBuilder();
		for (String str : stack) {
			System.out.println("str: " + str);
			res.append("/").append(str);
		}
		return res.toString();
	}
	
	static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		StringBuilder current = new StringBuilder();
		boolean hasAlphabets = false;
		boolean hasPeriods = false;
		
		for (Character c : path.toCharArray()) {
			if (c == '/') {
				if (!current.isEmpty()) {
					if (hasAlphabets) {
						stack.push(current.toString());
					}
					else {
						if (current.length() > 2) {
							stack.push(current.toString());
						}
						else if (current.length() == 2 && !stack.isEmpty()) {
							stack.pop();
						}
						// 1 . - just skip
					}
				}
				hasAlphabets = hasPeriods = false;
				current.setLength(0);
			}
			else if (c == '.') {
				hasPeriods = true;
				current.append(c);
			}
			else {
				hasAlphabets = true;
				current.append(c);
			}
		}
		
		if (!current.isEmpty()) {
			if (hasAlphabets)
				stack.push(current.toString());
			else {
				if (current.length() > 2) {
					stack.push(current.toString());
				}
				else if (current.length() == 2 && !stack.isEmpty()) {
					stack.pop();
				}
			}
		}

		if (stack.isEmpty())
			return "/";			
		System.out.println(stack);
		StringBuilder res = new StringBuilder();
		for (String str : stack) {
			res.append("/").append(str);
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
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