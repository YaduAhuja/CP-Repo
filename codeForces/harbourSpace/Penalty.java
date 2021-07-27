/**
 * Problem Link : https://codeforces.com/contest/1553/problem/C
 * Runtime : 0.186s
 */
package codeForces.harbourSpace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Penalty {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(getMinKicks(br.readLine().trim())).append('\n');
        }
        br.close();
        System.out.println(sb);
    }

    private static int getMinKicks(String s) {
        char arr[] = s.toCharArray();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            // Making 1 win
            if (i % 2 == 0 && arr[i] == '?') arr[i] = '1';
        }
        min = Math.min(getMinTime(arr), min);

        arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            // Making 2 win
            if (i % 2 != 0 && arr[i] == '?') arr[i] = '1';
        }

        min = Math.min(getMinTime(arr), min);
        return min;
    }

    private static int getMinTime(char arr[]) {
        int team1 = 0;
        int team2 = 0;
        int possibleScore1 = 5;
        int possibleScore2 = 5;
        int i = 0;
        boolean breakedEarly = false;

        for (; i < arr.length; i++) {
            if (arr[i] == '1') {
                if (i % 2 == 0) team1++;
                else team2++;
            }

            if (i % 2 == 0) possibleScore1--;
            else possibleScore2--;

            if (team1 + possibleScore1 < team2) {
                breakedEarly = true;
                break;
            } else if (team2 + possibleScore2 < team1) {
                breakedEarly = true;
                break;
            }
        }
        // System.out.println(team1 +"  " + possibleScore1);
        // System.out.println(team2 +"  " + possibleScore2);
        if (breakedEarly) return i + 1;
        return i;
    }
}
