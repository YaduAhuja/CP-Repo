/**
 *  Problem Link : https://codeforces.com/contest/1573/problem/A
 *  Runtime :  0.218s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Countdown {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();
        while (t-- > 0) {
            br.readLine();
            String s = br.readLine().trim();
            sb.append(getValue(s)).append("\n");
        }

        br.close();
        System.out.println(sb);
    }

    private static int getValue(String s) {
        int ret = 0;
        for (char c : s.toCharArray()) {
            int x = Integer.parseInt(c + "");
            if (x > 0) ret += ++x;
        }
        if (s.charAt(s.length() - 1) == '0') return ret;
        return ret - 1;
    }
}
