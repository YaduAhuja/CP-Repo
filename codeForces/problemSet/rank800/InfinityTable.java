/**
 *  Problem Link : https://codeforces.com/problemset/problem/1560/C
 *  Runtime : 0.217s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InfinityTable {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(getValue(n)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String getValue(int n) {
        long i = 1;
        long cur = 1;
        // Calculating the Values Along the Diagonals
        while (n > (cur + i - 1)) {
            i++;
            cur = (i * i - i) + 1;
        }

        long row = i;
        long col = i;
        if (n > cur) {
            col -= n - cur;
        } else {
            row -= cur - n;
        }

        return row + " " + col;
    }
}
