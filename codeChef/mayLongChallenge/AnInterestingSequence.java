/**
 *  Problem Link : https://www.codechef.com/MAY21B/problems/ISS
 * 	Runtime : 0.78s
 */
package codeChef.mayLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AnInterestingSequence {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        long t1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(getSum(Integer.parseInt(br.readLine().trim()))).append("\n");
        }
        br.close();
        System.out.print(sb);
        System.out.println((System.currentTimeMillis() - t1) + " ms");
    }

    private static int getSum(int k) {
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> gcd = new ArrayList<>();
        for (int i = 1; i <= 2 * k + 1; i++) arr.add(k + (i * i));
        for (int i = 1; i < arr.size(); i++) {
            gcd.add(gcd(arr.get(i - 1), arr.get(i)));
        }
        for (int i : gcd) sum += i;
        return sum;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
