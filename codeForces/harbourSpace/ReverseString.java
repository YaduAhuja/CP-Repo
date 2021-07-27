/**
 * Problem Link : https://codeforces.com/contest/1553/problem/B
 * Runtime : 0.170s
 */
package codeForces.harbourSpace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = br.readLine().trim();
            String q = br.readLine().trim();
            boolean x = isPossible(s, q);
            if (x) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        br.close();
        System.out.println(sb);
    }

    private static boolean isPossible(String s, String q) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == q.charAt(0)) {
                if (canBuild(s, i, q)) return true;
            }
        }
        return false;
    }

    private static boolean canBuild(String s, int i, String q) {
        int j = 0;
        for (; j < q.length() && i < s.length(); j++) {
            if (s.charAt(i) == q.charAt(j)) {
                if (i > 0
                        && j + 1 < q.length()
                        && s.charAt(i - 1) == q.charAt(j + 1)
                        && isReverse(s, q, i - 1, j + 1)) return true;
                i++;
            } else break;
        }

        i -= 2;

        // System.out.println(i +"  "+ j);
        for (; j < q.length() && i >= 0; j++) {
            if (s.charAt(i) == q.charAt(j)) i--;
            else break;
        }

        if (j >= q.length()) return true;
        return false;
    }

    private static boolean isReverse(String s, String q, int i, int j) {
        // System.out.println(i +"  "+ j);
        for (; j < q.length() && i >= 0; j++, i--) {
            if (s.charAt(i) != q.charAt(j)) return false;
        }
        if (j >= q.length()) return true;
        return false;
    }
}
