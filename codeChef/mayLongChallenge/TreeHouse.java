/**
 *  Problem Link : https://www.codechef.com/MAY21B/problems/THOUSES
 * 	Runtime : 1.11s
 */

// This Problem Uses Dp on Trees

package codeChef.mayLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TreeHouse {

    private static final int mod = (int) 1e9 + 7;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            Node[] graph = new Node[n + 1];
            for (int j = 0; j < graph.length; j++) graph[j] = new Node();
            for (int j = 1; j < n; j++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                int source = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());

                graph[source].neighbours.add(graph[dest]);
                graph[dest].neighbours.add(graph[source]);
            }

            sb.append(getSum(graph, x)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int getSum(Node graph[], int x) {
        graph[1].neighbours.add(graph[0]);
        dfs(graph[1], graph[0]);

        // for(int i = 0; i < graph.length; i++)graph[i].weight = i;
        // Arrays.sort(graph);
        // System.out.println(Arrays.toString(graph));

        graph[1].weight %= mod;
        long sum = (graph[1].weight * x) % mod;
        return (int) sum;
    }

    private static void dfs(Node cur, Node prev) {
        if (cur.visited) return;
        cur.visited = true;

        if (cur.neighbours.size() == 1) {
            cur.weight = 1;
            return;
        }

        for (Node i : cur.neighbours) {
            if (i == prev) continue;
            dfs(i, cur);
        }

        Collections.sort(cur.neighbours);
        long ret = 0;
        int multiplier = 1;
        for (Node i : cur.neighbours) {
            if (i == prev) continue;
            ret += i.weight * multiplier;
            multiplier++;
        }

        cur.weight = ret + 1;
    }

    private static class Node implements Comparable<Node> {
        long weight;
        boolean visited;
        List<Node> neighbours;

        Node() {
            this.neighbours = new ArrayList<>();
        }

        public int compareTo(Node o) {
            if (o.weight > this.weight) return 1;
            if (o.weight < this.weight) return -1;
            return 0;
        }

        public String toString() {
            return Long.toString(this.weight);
        }
    }
}
