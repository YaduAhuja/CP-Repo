package hackerRank.interviewPreparationKit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FindingNearestClone {
    static class Node {
        int dist;
        ArrayList<Node> neighbours;
        int colour;
        boolean shortest;

        public Node() {
            this.dist = Integer.MAX_VALUE;
            neighbours = new ArrayList<>();
            this.shortest = false;
        }

        public String toString() {
            return this.dist + "  " + this.colour;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int graphNodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        Node[] graph = new Node[graphNodes];
        for (int i = 0; i < graph.length; i++) graph[i] = new Node();
        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int source = Integer.parseInt(st.nextToken()) - 1;
            int destination = Integer.parseInt(st.nextToken()) - 1;
            graph[source].neighbours.add(graph[destination]);
            graph[destination].neighbours.add(graph[source]);
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < graphNodes; i++) graph[i].colour = Integer.parseInt(st.nextToken()) - 1;
        int q = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(Shortestdistance(graph, q - 1, graph[q - 1].colour));
    }

    static int Shortestdistance(Node graph[], int q, int colour) {
        PriorityQueue<Node> DijkstraQueue = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        graph[q].dist = 0;
        DijkstraQueue.add(graph[q]);
        while (!DijkstraQueue.isEmpty()) {
            Node temp = DijkstraQueue.remove();
            temp.shortest = true;
            for (Node i : temp.neighbours) {
                i.dist = Math.min(i.dist, temp.dist + 1);
                if (!i.shortest) DijkstraQueue.add(i);
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++)
            if (graph[i].colour == colour && i != q) ret = Math.min(ret, graph[i].dist);
        //		System.out.println(Arrays.toString(graph));
        if (ret == Integer.MAX_VALUE) return -1;
        else return ret;
    }
}
