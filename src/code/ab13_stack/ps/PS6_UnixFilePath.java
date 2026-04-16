package code.ab13_stack.ps;

import java.util.Arrays;
import java.util.Stack;

/**
 * @since 15-04-2026
 * 
 * If the problem has:
 * 	nesting ((), [])
 * 	undo (..)
 * 	hierarchical structure
 * *** Think stack immediately
 */
public class PS6_UnixFilePath {

	/**
	 * LC 71. Simplify Path
	 * CAN BE IMPROVED
	 * @param path
	 * @return
	 */
	static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : path.toCharArray()) {
        	if (c == '/') {
        		if (!sb.isEmpty()) {
        			stack.push(sb.toString());
//        			sb.delete(0, sb.length());
        			sb.setLength(0);
        		}
        	}
        	else {
    			sb.append(c);
    		}
        }
        
        if (!sb.isEmpty()) {
        	stack.push(sb.toString());
        	sb.setLength(0);
        }
        
        System.err.println(stack);
        
        String[] strs= new String[stack.size()];
        int j = 0;
        int deleteCount = 0;
        
        // only this part needs to be corrected
        while (!stack.isEmpty()) {
        	String curr = stack.pop();
        	if (curr.equals("..")) {
//        		if (!stack.isEmpty())
//        			stack.pop();
        		deleteCount++;
        	}
        	else if (curr.equals(".")) {
        		
        	}
        	else {
        		if (deleteCount > 0) {
        			deleteCount--;
        		}
        		else
        			strs[j] = curr;
        	}
        	j++;
        }
        
        System.err.println(Arrays.toString(strs));
        
        StringBuilder simplifiedPath = new StringBuilder();
        for (int k = strs.length-1; k >= 0 ; k--) {
        	if (strs[k] != null && !strs[k].equals(".")) {
        		simplifiedPath.append('/');
        		simplifiedPath.append(strs[k]);
        	}
        }
        
		return simplifiedPath.toString().isBlank() ? "/" : simplifiedPath.toString();
    }
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("abc");
		System.err.println(sb.toString());
		sb.delete(0, sb.length());
		System.err.println(sb.toString());
		
		String path = "/home/user/Documents/../Pictures";
		System.out.println(simplifyPath(path));
		path = "/../";
		System.out.println(simplifyPath(path));
		
		path = "/.../a/../b/c/../d/./";
		System.out.println(simplifyPath(path));    // "/.../b/d"
		
		path = "/a/./b/../../c/";
		System.err.println(simplifyPath(path));    // "/c"
	}
}
