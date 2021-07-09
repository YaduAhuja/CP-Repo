/**
 * Problem Link : https://codeforces.com/problemset/problem/1343/A
 * Runtime : 0.187s
 */
package codeForces.problemSet.rank900;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Candies {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++)
            sb.append(getCandies(Integer.parseInt(br.readLine().trim()))).append("\n");

        br.close();
        System.out.print(sb);
    }

    private static int getCandies(int n) {
        int ret = 0;
        for (int k = 2; k < 30; k++) {
            int div = (1 << k) - 1;
            if (n % div == 0) {
                ret = n / div;
                break;
            }
        }
        return ret;
    }
}
