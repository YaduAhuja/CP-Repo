/**
 *  Problem Link : https://codeforces.com/problemset/problem/1560/A
 *  Runtime : 0.202s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DislikeOfThrees {
    private static ArrayList<Integer> nums;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        nums = new ArrayList<>();

        int arr[] = new int[t];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
            max = Math.max(arr[i], max);
        }
        br.close();

        preprocess(max);
        System.out.println(serveQueries(arr));
    }

    private static void preprocess(int max) {
        nums.add(1);
        for (int i = 1; i < max; i++) {
            int n = nums.get(i - 1) + 1;
            while (n % 3 == 0 || n % 10 == 3) n++;
            nums.add(n);
        }
    }

    private static String serveQueries(int arr[]) {
        var sb = new StringBuilder();
        for (int i : arr) {
            sb.append(nums.get(i - 1)).append("\n");
        }
        return sb.toString();
    }
}
