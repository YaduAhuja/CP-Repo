/**
 * Problem Link : https://www.codechef.com/COOK131B/problems/CHFGCD
 * Runtime : 0.23s
 */
package codeChef.julyCookOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefAndGCD {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int input[] = nextIntArray(2, br);
            sb.append(getMinOps(input)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int getMinOps(int arr[]) {
        if (arr[0] % 2 == 0 && arr[1] % 2 == 0) return 0;
        else if (getGCD(arr[0], arr[1]) != 1) return 0;
        else if (getGCD(arr[0] + 1, arr[1]) > 1 || getGCD(arr[0], arr[1] + 1) > 1) return 1;
        return 2;
    }

    private static int getGCD(int a, int b) {
        if (a == 0) return b;
        return getGCD(b % a, a);
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
