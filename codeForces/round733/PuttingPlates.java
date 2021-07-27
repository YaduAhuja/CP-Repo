/**
 * Problem Link : https://codeforces.com/contest/1530/problem/B
 * Runtime : 0.171s
 */
package codeForces.round733;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PuttingPlates {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            sb.append(getMatrix(h, w)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String getMatrix(int h, int w) {
        boolean matrix[][] = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (isValid(matrix, i, j)) {
                    matrix[i][j] = true;
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for (boolean b[] : matrix) {
            for (boolean x : b) {
                if (x) ret.append('1');
                else ret.append('0');
            }
            ret.append("\n");
        }

        return ret.toString();
    }

    private static boolean isValid(boolean matrix[][], int i, int j) {
        // Checking Sides
        if (i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[0].length - 1) {
            if (getVal(matrix, i - 1, j)
                    || getVal(matrix, i, j - 1)
                    || getVal(matrix, i + 1, j)
                    || getVal(matrix, i, j + 1)
                    || getVal(matrix, i - 1, j - 1)
                    || getVal(matrix, i - 1, j + 1)
                    || getVal(matrix, i + 1, j - 1)
                    || getVal(matrix, i + 1, j + 1)) {
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean getVal(boolean matrix[][], int i, int j) {
        if (i == -1 || i == matrix.length || j == -1 || j == matrix[0].length) {
            return false;
        }
        return matrix[i][j];
    }
}
