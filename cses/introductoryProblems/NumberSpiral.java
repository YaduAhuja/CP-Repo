/**
 *  Problem Link : https://cses.fi/problemset/task/1071/
 *  Runtime : 0.59s
 */
package cses.introductoryProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberSpiral {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int queries[][] = new int[t][2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
            max = Math.max(Math.max(queries[i][0], queries[i][1]), max);
        }
        br.close();
        System.out.println(getResult(queries, max));
    }

    private static String getResString(int maxX, int maxY) {
        long ret = 1;
        if (maxX == 1 && maxY == 1) return ret + "";

        ret = getDiagonalValue(Math.max(maxX, maxY));
        int diff = Math.abs(maxX - maxY);

        if (maxX > maxY) {
            if ((maxX & 1) == 1) ret -= diff;
            else ret += diff;
        } else {
            if ((maxY & 1) == 1) ret += diff;
            else ret -= diff;
        }

        return "" + ret;
    }

    private static long getDiagonalValue(int i) {
        return (long) i * i - (i - 1);
    }

    private static String getResult(int queries[][], int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queries.length; i++)
            sb.append(getResString(queries[i][0], queries[i][1]) + "\n");
        return sb.toString();
    }
}
