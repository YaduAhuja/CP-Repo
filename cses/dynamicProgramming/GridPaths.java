/**
 *  Problem Link : https://cses.fi/problemset/task/1638
 *  Runtime : 0.24s
 */
package cses.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GridPaths {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine().trim());
        char grid[][] = new char[rows][];
        for (int i = 0; i < rows; i++) grid[i] = br.readLine().trim().toCharArray();
        br.close();

        System.out.println(countPaths(grid));
    }

    private static int countPaths(char grid[][]) {
        // Top Down DP Sol
        if (grid[0][0] == '*' || grid[grid.length - 1][grid[0].length - 1] == '*') return 0;
        if (grid.length == 1 && grid[0].length == 1) return 1;
        if (grid[grid.length - 1][grid[0].length - 2] == '*'
                && grid[grid.length - 2][grid[0].length - 1] == '*') return 0;

        final int mod = (int) 1e9 + 7;
        int dp[][] = new int[grid.length][grid[0].length];
        dp[dp.length - 1][dp[0].length - 1] = 1;

        // Preprocessing
        for (int i = dp.length - 2; i > -1 && grid[i][grid[0].length - 1] != '*'; i--)
            dp[i][dp[0].length - 1] = dp[i + 1][dp[0].length - 1];
        for (int i = dp[0].length - 2; i > -1 && grid[grid.length - 1][i] != '*'; i--)
            dp[dp.length - 1][i] = dp[dp.length - 1][i + 1];

        // DP Start
        for (int i = dp.length - 2; i > -1; i--) {
            for (int j = dp[0].length - 2; j > -1; j--) {
                if (grid[i][j] == '*') continue;
                dp[i][j] = (getVal(dp, i + 1, j) + getVal(dp, i, j + 1)) % mod;
            }
        }
        return dp[0][0];
    }

    private static int getVal(int dp[][], int i, int j) {
        if (!(i > -1 && i < dp.length && j > -1 && j < dp[0].length)) return 0;
        return dp[i][j];
    }
}
