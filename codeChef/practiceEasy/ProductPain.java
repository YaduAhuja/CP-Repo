/**
 * Problem Link : https://www.codechef.com/problems/PRDTPAIN
 * Runtime : 1.51s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ProductPain {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            long[] arr = nextLongArray(N, br);
            sb.append(getWeight(arr)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static long getWeight(long[] arr) {
        long ret = 0;
        TreeSet<Long> set = new TreeSet<>();
        for (long i : arr) set.add(i);

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 2; j < arr.length; j++) {
                NavigableSet<Long> subSet = set.subSet(arr[i], true, arr[j], true);
                long max = 0;
                ArrayList<Long> possible = new ArrayList<>();
                long mid = (arr[i] + arr[j]) / 2;
                possible.add(subSet.ceiling(mid));
                possible.add(subSet.floor(mid));
                for (long e : possible) max = Math.max(findVal(arr[i], e, arr[j]), max);

                ret += max;
            }
        }
        return ret;
    }

    private static long findVal(long i, long j, long k) {
        return (i - j) * (j - k);
    }

    private static long[] nextLongArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        long arr[] = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
        return arr;
    }
}
