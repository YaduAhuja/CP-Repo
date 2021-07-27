/**
 * Problem Link: https://codeforces.com/contest/1553/problem/D
 * Runtime: 0.202s
 */
package codeForces.harbourSpace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BackSpace {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = br.readLine().trim();
            String q = br.readLine().trim();
            boolean possible = isPossible(s, q);
            if (possible) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        br.close();
        System.out.println(sb);
    }

    private static boolean isPossible(String s, String q) {
        int i = s.length() - 1;
        int j = q.length() - 1;

        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == q.charAt(j)) {
                i--;
                j--;
            } else {
                i -= 2;
            }
        }

        if (j < 0) return true;
        return false;
    }
}
