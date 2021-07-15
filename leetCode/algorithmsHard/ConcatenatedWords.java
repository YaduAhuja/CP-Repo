/**
 * Problem Link : https://leetcode.com/problems/concatenated-words/
 * Runtime : 0.059s
 */

package leetCode.algorithmsHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
	private static Set<String> tempSet;
	
	public static void main(String[] args) {
		String words[] = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		System.out.println(findAllConcatenatedWordsInADict(words));
	}


	private static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ret = new ArrayList<>();
		tempSet = new HashSet<>();
		Arrays.sort(words, (a,b) -> a.length() - b.length());
		for(String s : words){
			if(s.isEmpty()) continue;
			if(isConcatenated(s)) ret.add(s);
			else tempSet.add(s);
		}
		return ret;
    }


	private static boolean isConcatenated(String s) {
		if(s.isEmpty()) return true;
		for(int i = 1; i <= s.length(); i++){
			if(tempSet.contains(s.substring(0, i)) && isConcatenated(s.substring(i))) 
				return true;
		}
		return false;
	}
}
