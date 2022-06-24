/**
 * Problem Link : https://www.codechef.com/EXUN21B/problems/RAINDROPS
 * Runtime : 0.90s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HarshikaAndTheRain {
    private static int dist[];
    private static ArrayList<Integer> leaves;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int inp[] = nextIntArray(2, br);
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= inp[0]; i++) graph.add(new ArrayList<>());
            for (int i = 1; i < inp[0]; i++) {
                int in[] = nextIntArray(2, br);
                graph.get(in[0]).add(in[1]);
                graph.get(in[1]).add(in[0]);
            }
            int shakes[] = nextIntArray(inp[1], br);
            sb.append(solve(graph, shakes)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static long solve(ArrayList<ArrayList<Integer>> graph, int shakes[]) {
        dist = new int[graph.size()];
        // Very Important so that root is never considered as leaf
        graph.get(1).add(0);
        leaves = new ArrayList<>();
        dist[0] = -1;
        dfs(graph, 0, 1);
        int maxDist = 0;
        for (int i : dist) maxDist = Math.max(i, maxDist);

        // Time is the prefix sum generated till the maxDistance from leaf to root
        long time[] = new long[maxDist + 2];
        for (int i : leaves) time[dist[i] + 1]++;

        // Add is the leaves which have completed the first batch of traversal and
        // now they are in the queue for every second
        long add = 0;
        for (int i = 1; i < time.length; i++) {
            long temp = time[i];
            time[i] += time[i - 1] + add;
            add += temp;
        }

        // System.out.println(Arrays.toString(time));
        // System.out.println(leaves);
        // System.out.println(Arrays.toString(dist));
        long rootDrops = 0;
        int prev = 0;
        for (int i : shakes) {
            int diff = i - prev;
            long cur = 0;
            if (diff >= time.length) {
                diff -= (time.length - 1);
                cur = diff * add;
                cur += time[time.length - 1];
            } else {
                cur = time[diff];
            }
            rootDrops += cur;
            prev = i;
        }

        return rootDrops;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int prev, int cur) {
        dist[cur] = dist[prev] + 1;

        ArrayList<Integer> connections = graph.get(cur);
        if (connections.size() == 1) leaves.add(cur);
        else
            for (int i : connections) {
                if (i == prev) continue;
                dfs(graph, cur, i);
            }
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
