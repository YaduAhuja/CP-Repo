/**
 *  Problem Link : https://www.codechef.com/problems/CCHEAVEN
 *  Runtime : 0.15s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChefInHeaven {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            br.readLine();
            String s = br.readLine().trim();
            sb.append(canGoToHeaven(s)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String canGoToHeaven(String s) {
        int goodCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') goodCount++;
            if (Math.ceil(((float) i + 1) / 2) <= goodCount) return "YES";
        }
        return "NO";
    }
}
