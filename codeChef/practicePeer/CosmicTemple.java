package codeChef.practicePeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CosmicTemple {
    private static int up[], down[], downNodes[];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(t);
        for (int i = 0; i < t; i++) graph.add(new ArrayList<>());
        up = new int[t];
        down = new int[t];
        downNodes = new int[t];

        for (int i = 1; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int source = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            graph.get(source).add(dest);
            graph.get(dest).add(source);
        }

        br.close();
        System.out.println(calculateDistances(graph));
    }

    private static String calculateDistances(ArrayList<ArrayList<Integer>> graph) {
        dfsDown(graph, 0, -1);
        calculateUP(graph, 0, -1, graph.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < up.length; i++) sb.append(up[i] + down[i]).append(" ");
        return sb.toString();
    }

    private static void dfsDown(ArrayList<ArrayList<Integer>> graph, int node, int prev) {
        downNodes[node]++;
        for (int i : graph.get(node)) {
            if (i == prev) continue;
            dfsDown(graph, i, node);
            downNodes[node] += downNodes[i];
            down[node] += down[i] + downNodes[i];
        }
    }

    private static void calculateUP(
            ArrayList<ArrayList<Integer>> graph, int node, int prev, int n) {
        if (prev != -1) up[node] = n + up[prev] + down[prev] - down[node] - downNodes[node] * 2;
        for (int i : graph.get(node)) {
            if (i == prev) continue;
            calculateUP(graph, i, node, n);
        }
    }
}
