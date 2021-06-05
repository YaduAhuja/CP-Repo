/**
 *  Problem Link : https://cses.fi/problemset/task/1667
 *  Runtime : 0.83s
 */
package cses.graphAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MessageRoute {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int nodes = Integer.parseInt(st.nextToken());
        int roads = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(nodes);

        for (int i = 0; i <= nodes; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < roads; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int source = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            graph.get(source).add(dest);
            graph.get(dest).add(source);
        }

        br.close();
        System.out.println(getMinNodes(graph));
    }

    private static String getMinNodes(ArrayList<ArrayList<Integer>> graph) {
        boolean visited[] = new boolean[graph.size()];
        int prev[] = new int[graph.size()];
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(1);

        visited[1] = true;
        while (!bfsQueue.isEmpty()) {
            int i = bfsQueue.remove();
            if (i == graph.size() - 1) break;
            for (int j : graph.get(i)) {
                if (visited[j] == false) {
                    visited[j] = true;
                    bfsQueue.add(j);
                    prev[j] = i;
                }
            }
        }

        if (!visited[visited.length - 1]) return "IMPOSSIBLE";

        Deque<String> retList = new LinkedList<>();
        int n = graph.size() - 1;
        while (true) {
            if (n < 1) break;
            retList.addFirst(n + " ");
            n = prev[n];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(retList.size() + "\n");
        while (!retList.isEmpty()) sb.append(retList.removeFirst());
        return sb.toString();
    }
}
