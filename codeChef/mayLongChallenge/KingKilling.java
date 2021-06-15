/**
 *  Problem Link : https://www.codechef.com/MAY21B/problems/KKLING
 *  Runtime : 2.18s
 */
package codeChef.mayLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class KingKilling {
    private static ArrayList<Node> ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            Node[] graph = new Node[n + 1];
            for (int j = 0; j < n + 1; j++) graph[j] = new Node(j);

            for (int j = 0; j < n - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
                int source = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());

                graph[source].neighbours.add(graph[dest]);
                graph[dest].neighbours.add(graph[source]);
            }
            sb.append(getAssassins(graph)).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static StringBuilder getAssassins(Node[] graph) {
        StringBuilder sb = new StringBuilder();
        dfsUpdateTime(graph[1], graph[1]);
        ans = new ArrayList<>();
        dfsFindNodes(graph[1], graph[1], graph[1].dp);
        Collections.sort(ans, (o1, o2) -> o1.id - o2.id);
        sb.append(ans.size()).append(" ").append(graph[1].dp).append("\n");
        for (Node i : ans) sb.append(i.id).append(" ");
        return sb;
    }

    private static void dfsFindNodes(Node cur, Node par, int T) {
        if (T > cur.dp) {
            return;
        }

        for (Node i : cur.neighbours) {
            if (i == par) continue;
            if (cur == par) {
                if (i.dp == T - 1) {
                    dfsFindNodes(i, cur, T - 1);
                }
            } else {
                if (T < cur.dp) {
                    dfsFindNodes(i, cur, T);
                } else {
                    dfsFindNodes(i, cur, T - 1);
                }
            }
        }

        if (T == 0) {
            ans.add(cur);
        }
    }

    private static void dfsUpdateTime(Node cur, Node par) {
        int maxDist = Integer.MIN_VALUE;
        int minDist = Integer.MAX_VALUE;
        // Checking the Leaf Node
        if (cur.neighbours.size() == 1 && cur != par) {
            cur.dp = 0;
            return;
        }

        for (Node i : cur.neighbours) {
            if (i == par) continue;
            dfsUpdateTime(i, cur);
            maxDist = Math.max(maxDist, i.dp);
            minDist = Math.min(minDist, i.dp);
        }

        if (maxDist == minDist || cur == par) {
            // No Killing
            cur.dp = minDist + 1;
        } else {
            cur.dp = minDist + 2;
        }
    }

    private static class Node {
        int id;
        ArrayList<Node> neighbours;
        int dp;

        Node(int id) {
            this.id = id;
            this.neighbours = new ArrayList<>();
            this.dp = Integer.MAX_VALUE;
        }

        public String toString() {
            return this.id + "";
        }
    }
}
