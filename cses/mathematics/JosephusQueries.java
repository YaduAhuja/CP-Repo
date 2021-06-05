/**
 *  Problem Link :
 *  Runtime : 0.36s
 */
package cses.mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JosephusQueries {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            sb.append(solveOptimized(n, q)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int solveOptimized(int n, int q) {
        if (n == 1) return 1;
        int solved = (n + 1) / 2;
        if (q <= solved) {
            if (2 * q > n) return (2 * q) % n;
            return 2 * q;
        }
        int ret = solveOptimized(n / 2, q - solved);
        if (n % 2 == 1) return 2 * ret + 1;
        return 2 * ret - 1;
    }
}
