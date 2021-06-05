/**
 *  Problem Link : https://www.codechef.com/MAY21B/problems/TCTCTOE
 *  Runtime : 0.14s
 */
package codeChef.mayLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TicTacToe {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder(t * 2);
        for (int i = 0; i < t; i++) {
            char grid[][] = new char[3][3];
            for (int j = 0; j < 3; j++) {
                grid[j] = br.readLine().trim().toCharArray();
            }
            sb.append(canReach(grid)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int canReach(char grid[][]) {
        int xWonCount = wonCount(grid, 'X');
        int oWonCount = wonCount(grid, 'O');

        int arr[] = cellCounter(grid);
        int xCount = arr[0];
        int oCount = arr[1];
        int emptyCount = arr[2];

        // Not Reachable Position
        if (xCount - oCount > 1 || xCount - oCount < 0) return 3;
        if (xWonCount > 0 && oWonCount > 0) return 3;
        if (xWonCount > 0 && oWonCount == 0 && xCount - oCount == 0) return 3;
        if (oWonCount > 0 && oCount != xCount) return 3;

        if (xWonCount == 0 && oWonCount == 0 && emptyCount > 0) return 2;

        return 1;
    }

    private static int[] cellCounter(char grid[][]) {
        int ret[] = {0, 0, 0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X') ret[0]++;
                else if (grid[i][j] == 'O') ret[1]++;
                else ret[2]++;
            }
        }
        return ret;
    }

    private static int wonCount(char[][] grid, char c) {
        int wonCount = 0;
        // Diagonal Check
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] == c) wonCount++;
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] == c) wonCount++;

        // Vertical Checks
        if (grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && grid[0][0] == c) wonCount++;
        if (grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1] && grid[0][1] == c) wonCount++;
        if (grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && grid[0][2] == c) wonCount++;

        // Horizontal Checks
        if (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][0] == c) wonCount++;
        if (grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][0] == c) wonCount++;
        if (grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][0] == c) wonCount++;

        return wonCount;
    }
}
