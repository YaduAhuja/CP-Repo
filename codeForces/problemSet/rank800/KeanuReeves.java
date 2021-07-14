/**
 *  Problem Link : https://codeforces.com/problemset/problem/1189/A
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeanuReeves {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine().trim();
        br.close();

        int ZCount = 0, OCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') ZCount++;
            else OCount++;
        }

        if (ZCount != OCount) {
            System.out.println(1);
            System.out.println(s);
        } else {
            System.out.println(2);
            System.out.println(s.substring(0, s.length() - 1) + " " + s.substring(s.length() - 1));
        }
    }
}
