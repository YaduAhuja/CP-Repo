/**
 * Problem Link : https://leetcode.com/problems/word-break/
 * Runtime : 6ms
 */
package leetCode.algorithmsMedium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    static HashSet<String> dict;
    static HashMap<String, Boolean> map;

    public static void main(String[] args) {
        String s = "abcd";
        List<String> wordDict = List.of("a", "abc", "b", "cd");
        System.out.println(wordBreak(s, wordDict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        dict = new HashSet<>(wordDict);
        map.put("", true);
        return recurse(s);
    }

    private static boolean recurse(String s) {
        // System.out.println(s);
        s = s.trim();
        if (map.containsKey(s)) return map.get(s);
        int left = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(left, i))) {
                map.put(s, map.getOrDefault(s, false) || recurse(s.substring(i)));
            }
        }

        if (map.containsKey(s)) return map.get(s);
        return false;
    }
}
