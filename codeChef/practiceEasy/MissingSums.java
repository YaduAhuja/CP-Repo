/**
 * Problem Link : https://www.codechef.com/problems/MISSSUMS
 * Runtime : 0.10s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MissingSums {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(getArray(n)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String getArray(int n) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (int) 1e5 + 1 && count < n; i++) {
            if (i % 2 == 1) {
                sb.append(i).append(" ");
                count++;
            }
        }

        return sb.toString();
    }
}
