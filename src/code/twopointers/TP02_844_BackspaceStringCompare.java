package code.twopointers;

public class TP02_844_BackspaceStringCompare {

	private static boolean backspaceCompare(String s, String t) {
		
		int right1 = s.length() - 1;
		int skip1 = 0;
		int right2 = t.length() - 1;
		int skip2 = 0;
//				String s = "ab##", t = "c#d#";
		while (right1 >= 0 && right2 >= 0) {
			while (right1 >= 0) {
				if (s.charAt(right1) == '#') {
					skip1++;
					right1--;
				}
				else if (skip1 > 0) {
					skip1--;
					right1--;
				}
				else
					break;
			}

			
			while (right2 >= 0) {
				if (t.charAt(right2) == '#') {
					skip2++;
					right2--;
				}
				else if (skip2 > 0) {
					skip2--;
					right2--;
				}
				else
					break;
			}
			
			if (right1 >= 0 && right2 >= 0) {
				if (s.charAt(right1) != t.charAt(right2))
					return false;
			}
			else {
				if (right1 >= 0 ^ right2 >= 0)
					return false;
			}
			
			right1--;
			right2--;
		}
		return true;
	}
	
	public static void main(String[] args) {
//		String s = "ab##", t = "c#d#";
//		String s = "a#c", t = "b";
//		String s = "ab##", t = "c#d#";
		String s = "a", t = "aa#a";
		System.err.println(backspaceCompare(s, t));
	}
}
