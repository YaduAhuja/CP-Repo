/**
 * Problem Link : https://leetcode.com/problems/word-break-ii/
 * Runtime : 4ms
 */

package leetCode.algorithmsHard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak2 {
	static HashSet<String> dict;
	static HashSet<String> using;
	static List<String> ret;
	public static void main(String[] args) {
		String s = "catsandog";
		List<String> wordDict = List.of("cats","dog","sand","and","cat");
		System.out.println(wordBreak(s, wordDict));
	}


	private static List<String> wordBreak(String s, List<String> wordDict) {
		using = new HashSet<>();
		dict = new HashSet<>(wordDict);
		recurse("", s);
		ret = new ArrayList<>(using);
		return ret;
    }


	private static void recurse(String prev, String s){
		// System.out.println(prev +"  "+ s);
		if(s.trim().length() == 0) {
			using.add(prev.trim());
			return;
		}

		for(int i = 1; i <= s.length(); i++){
			if(dict.contains(s.substring(0, i))){
				recurse(prev+" "+s.substring(0,i), s.substring(i));
			}	
		}
	}
}
