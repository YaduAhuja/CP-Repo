/**
 * Problem Link : https://codeforces.com/contest/1611/problem/C
 * Runtime : 0.311s
 */
package codeForces.problemSet.rank1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PolycarpRecoversThePermutation {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = nextIntArray(N, br);
            sb.append(getOps(arr)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String getOps(int[] arr) {
        int max = getMax(arr);
        if (max != arr[0] && arr[arr.length - 1] != max) return "-1";
        Deque<Integer> deq = new LinkedList<>();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (arr[left] > arr[right]) {
                deq.addFirst(arr[left]);
                left++;
            } else {
                deq.addLast(arr[right]);
                right--;
            }
        }
        var sb = new StringBuilder();
        while (!deq.isEmpty()) sb.append(deq.removeFirst()).append(" ");
        return sb.toString();
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    private static int getMax(int... arr) {
        int ret = Integer.MIN_VALUE;
        for (int i : arr) ret = Math.max(ret, i);
        return ret;
    }
}
