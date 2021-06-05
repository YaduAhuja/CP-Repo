package hackerRank.interviewPreparationKit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ShortestReachInGraph {
    private static class Node {
        int val, dist;
        boolean visited;
        ArrayList<Node> neighbours;

        Node(int val) {
            this.val = val;
            this.dist = -1;
            this.visited = false;
            this.neighbours = new ArrayList<>();
        }

        void updateNode(boolean visited, int dist) {
            this.visited = visited;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int nodeCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());

            Node[] graph = new Node[nodeCount + 1];
            for (int j = 1; j < graph.length; j++) graph[j] = new Node(j);

            for (int j = 0; j < edgeCount; j++) {
                st = new StringTokenizer(br.readLine().trim(), " ");
                int source = Integer.parseInt(st.nextToken());
                int destination = Integer.parseInt(st.nextToken());
                graph[source].neighbours.add(graph[destination]);
                graph[destination].neighbours.add(graph[source]);
            }

            int query = Integer.parseInt(br.readLine().trim());

            bfs(graph, query);

            for (int j = 1; j < graph.length; j++) {
                if (j == query) continue;
                sb.append(graph[j].dist + " ");
            }

            sb.append("\n");
        }
        br.close();

        System.out.println(sb);
    }

    private static void bfs(Node[] graph, int q) {
        Queue<Node> bfsQueue = new LinkedList<>();
        graph[q].updateNode(true, 0);
        bfsQueue.add(graph[q]);

        while (!bfsQueue.isEmpty()) {
            Node temp = bfsQueue.remove();
            for (int i = 0; i < temp.neighbours.size(); i++) {
                if (!temp.neighbours.get(i).visited) {
                    temp.neighbours.get(i).updateNode(true, temp.dist + 6);
                    bfsQueue.add(temp.neighbours.get(i));
                }
            }
        }
    }
}
