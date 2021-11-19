/**
 *  Problem Link : https://codeforces.com/contest/1579/problem/A
 *  Runtime : 0.202s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CasemirStringSolitaire {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();
        while (t-- > 0) {
            String s = br.readLine().trim();
            sb.append(getValidity(s)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String getValidity(String s) {
        int aCount = 0, bCount = 0, cCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') aCount++;
            if (c == 'B') bCount++;
            if (c == 'C') cCount++;
        }
        if (bCount == aCount + cCount) return "YES";
        return "NO";
    }
}
