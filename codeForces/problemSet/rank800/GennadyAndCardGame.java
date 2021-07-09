/**
 * Problem Link : https://codeforces.com/problemset/problem/1097/A
 * Runtime : 0.187s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GennadyAndCardGame {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp = br.readLine().trim();
        String[] cards = br.readLine().trim().split(" ");
        boolean found = false;
        for (String card : cards) {
            if (card.charAt(0) == inp.charAt(0) || card.charAt(1) == inp.charAt(1)) {
                found = true;
            }
        }

        br.close();
        if (found) System.out.println("YES");
        else System.out.println("NO");
    }
}
