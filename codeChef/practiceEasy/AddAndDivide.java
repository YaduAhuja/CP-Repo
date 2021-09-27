/**
 *  Problem Link : https://www.codechef.com/problems/ADDNDIV
 *  Runtime : 0.24s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AddAndDivide {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] input = nextIntArray(2, br);
            sb.append(checkValidity(input)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String checkValidity(int[] input) {
        int x = input[0], y = input[1];
        while (getGCD(x, y) != 1) {
            int gcd = getGCD(x, y);
            while (x % gcd == 0) x /= gcd;
        }

        if (x == 1) return "YES";
        return "NO";
    }

    private static int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
