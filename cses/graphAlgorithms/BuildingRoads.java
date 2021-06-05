/**
 *  Problem Link : https://cses.fi/problemset/task/1666
 *  Runtime : 0.62s
 */
package cses.graphAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BuildingRoads {
    static class Node {
        int index, size = 1;
        Node parent = this;

        Node(int index) {
            this.index = index;
        }

        Node findParent() {
            if (parent != this) {
                parent = parent.findParent();
            }
            return parent;
        }

        void merge(Node o) {
            Node oRoot = o.findParent();
            Node root = this.findParent();

            if (root == oRoot) return;

            oRoot.parent = root;
            root.size += oRoot.size;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");

        Node graph[] = new Node[Integer.parseInt(st.nextToken())];
        int roads = Integer.parseInt(st.nextToken());
        for (int i = 0; i < roads; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int source = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;

            if (graph[source] == null) graph[source] = new Node(source + 1);
            if (graph[dest] == null) graph[dest] = new Node(dest + 1);

            graph[source].merge(graph[dest]);
        }
        br.close();
        System.out.println(getRoads(graph));
    }

    private static String getRoads(Node graph[]) {
        HashSet<Node> NodeSet = new HashSet<>(graph.length);
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] != null) NodeSet.add(graph[i].findParent());
            else NodeSet.add(new Node(i + 1));
        }
        StringBuilder sb = new StringBuilder();
        sb.append((NodeSet.size() - 1) + "\n");
        Node temp = null;
        for (Node i : NodeSet) {
            if (temp == null) temp = i;
            else sb.append(i.index + " " + temp.index + "\n");
        }
        return sb.toString();
    }
}
