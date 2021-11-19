/**
 *  Problem Link : https://codeforces.com/contest/1579/problem/D
 *  Runtime : 0.296s
 */
package codeForces.problemSet.rank1400;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProductiveMeeting {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = nextIntArray(n, br);
            sb.append(getTalkings(arr));
        }
        br.close();
        System.out.println(sb);
    }

    private static String getTalkings(int[] arr) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            pq.add(new Pair(i + 1, arr[i]));
        }

        List<String> talks = new ArrayList<>();
        while (pq.size() > 1) {
            Pair cur = pq.remove();
            Pair cur1 = pq.remove();

            talks.add(cur1.id + " " + cur.id);

            cur.talks--;
            cur1.talks--;

            if (cur.talks > 0) pq.add(cur);
            if (cur1.talks > 0) pq.add(cur1);
        }

        var sb = new StringBuilder();
        sb.append(talks.size()).append("\n");
        for (String s : talks) sb.append(s).append("\n");
        return sb.toString();
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }

    private static class Pair implements Comparable<Pair> {
        private int id, talks;

        Pair(int id, int talks) {
            this.id = id;
            this.talks = talks;
        }

        @Override
        public int compareTo(Pair o) {
            return o.talks - talks;
        }

        @Override
        public String toString() {
            return "(" + id + ", " + talks + ")";
        }
    }
}
