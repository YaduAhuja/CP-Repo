/**
 * Problem Link : https://codeforces.com/contest/1549/problem/B
 * Runtime: 0.202s
 */
package codeForces.round736;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GregorAndPawnGame {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            char[][] board = new char[2][n];
            for (int j = 0; j < 2; j++) board[j] = br.readLine().trim().toCharArray();

            sb.append(getPawnsOptimized(board)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int getPawnsOptimized(char[][] board) {
        int ret = 0;

        for (int i = 0; i < board[0].length; i++) {
            if (board[1][i] == '1') {
                if (board[0][i] == '0') ret++;
                else if (i > 0 && board[0][i - 1] == '1') {
                    ret++;
                    board[0][i - 1] = '2';
                } else if (i + 1 < board[0].length && board[0][i + 1] == '1') {
                    ret++;
                    board[0][i + 1] = '2';
                }
            }
        }

        return ret;
    }
}
