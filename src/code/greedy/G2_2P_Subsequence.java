package code.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G2_2P_Subsequence {

	static int numOfSubsequences(String s, String[] words) {
		if (s.isBlank() || s.isEmpty() || words.length==0)
			return 0;
		
		int count = 0;
		
		for (String word: words) {
			if (isSubsequence(s, word)) {
				count++;
			}
		}
		
		return count;
	}
	
	private static boolean isSubsequence(String s, String word) {
		// s = abae
		// w = aba
		Map<Character, List<Integer>> indicesMap = new HashMap<Character, List<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			Character current = s.charAt(i);
			indicesMap.computeIfAbsent(current, ArrayList<Integer>::new).add(i);
		}
		int prevIndex = -1;
		for (int i = 0; i < word.length(); i++) {
			Character current = word.charAt(i);
			if (!indicesMap.containsKey(current))
				return false;
			
			List<Integer> indices = indicesMap.get(current);
			int pos = Collections.binarySearch(indices, prevIndex+1);
			
			if (pos<0) {
				pos = -(pos+1);		// insertion point
			}
			if (pos==indices.size()) {
				return false;			// s = "aaa"; w = "aaaa"
			}
			prevIndex = indices.get(pos);
		}
		
		return true;
	}

	public static void main(String[] args) {
		String s ="abae";
		String[] words = {"abc", "aba", "abe"};
		isSubsequence(s, "aba");
		System.err.println(numOfSubsequences(s, words));
		int pos = Collections.binarySearch(List.of(1, 3, 5), 2);
		System.out.println(pos);   // -2  // insertion point = 1; so pos = -insertion -1;
		int pos1 = Collections.binarySearch(List.of(1, 2, 3), 4);
		System.out.println(pos1); // -4
		int pos2 = Collections.binarySearch(List.of(1, 3, 5), 4);
		System.out.println(pos2); // -3
		int pos3 = Collections.binarySearch(List.of(1, 3, 5), 3);
		System.out.println(pos3);
	}
	
}