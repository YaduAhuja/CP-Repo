/**
 *  Problem Link : https://www.codechef.com/problems/GCDPRF
 *  Runtime : 0.37s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCDofPrefixes {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = nextIntArray(N, br);
            sb.append(getAns(arr)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String getAns(int[] arr) {
        int[] ret = new int[arr.length];
        int curGCD = arr[0];
        ret[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curGCD = getGCD(curGCD, arr[i]);
            if (curGCD != arr[i]) return "-1";
            ret[i] = curGCD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ret) sb.append(i).append(" ");
        return sb.toString();
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    private static int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }
}
