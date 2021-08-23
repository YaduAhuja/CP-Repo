/**
 *  Problem Link : https://codeforces.com/contest/1559/problem/B
 *  Runtime : 0.202s
 */
package codeForces.round738;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MochaAndRedAndBlue {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            br.readLine();
            String cur = br.readLine().trim();

            sb.append(fillValues(cur)).append("\n");
        }

        br.close();
        System.out.println(sb);
    }

    private static String fillValues(String s) {
        char arr[] = s.toCharArray();
        if (arr.length == 1 && arr[0] == '?') return "B";

        int count = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] != '?') count++;

        if (count == 0) arr[0] = 'B';

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '?' && arr[i - 1] != '?') {
                if (arr[i - 1] == 'B') arr[i] = 'R';
                else arr[i] = 'B';
            }
        }

        for (int i = arr.length - 2; i > -1; i--) {
            if (arr[i] == '?' && arr[i + 1] != '?') {
                if (arr[i + 1] == 'B') arr[i] = 'R';
                else arr[i] = 'B';
            }
        }

        return new String(arr);
    }
}
