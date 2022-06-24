/**
 * Problem Link : https://www.codechef.com/submit/CIRCLEGAME
 * Runtime : 0.16s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AujasvitAndCircleGame {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int inp[] = nextIntArray(2, br);
            sb.append(solve(inp[0], inp[1])).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String solve(int rotation, int players) {
        int res[] = new int[players + 1];
        res[1] = 1;

        for (int i = 2; i < res.length; i++) {
            int temp = rotation % i;
            if (temp == 0) temp = i;
            res[i] = res[i - 1];
            if (res[i] >= temp) res[i]++;
        }

        // for (int i = 1; i < res.length; i++)
        // res[i] = solve1(rotation, i);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < res.length; i++) sb.append(res[i]).append(" ");
        return sb.toString();
    }

    // Slow Simulation of Solution but needed for optimization
    private static int solveSimulate(int rotation, int players) {
        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 1; i <= players; i++) ts.add(i);

        while (ts.size() > 1) {
            // System.out.println(ts + " " + rotation);
            int end = rotation % ts.size();
            int val = ts.higher(end);
            ts.remove(val);
        }

        return ts.first();
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
