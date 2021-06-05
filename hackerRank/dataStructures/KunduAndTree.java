package hackerRank.dataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class KunduAndTree {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        long mod = (long) 10e8 + 7;

        DisjointSet[] graph = new DisjointSet[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);

            if (color == 'r') continue;
            DisjointSet a = LazyCreate(graph, start);
            DisjointSet b = LazyCreate(graph, end);

            a.union(b);
        }
        br.close();
        HashSet<DisjointSet> dsj = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] != null) dsj.add(graph[i].findParent()); // main lines
            // add only parent dsj's in the unique set
        }

        long totalTriplets = comb3(n);

        for (DisjointSet selected : dsj) {
            totalTriplets -= comb3(selected.size);
            totalTriplets -= comb2(selected.size) * (n - selected.size);
        }

        System.out.println(totalTriplets % mod);
    }

    private static DisjointSet LazyCreate(DisjointSet[] graph, int index) {
        if (graph[index] == null) graph[index] = new DisjointSet();
        return graph[index];
    }

    private static long comb3(int n) {
        if (n < 3) return 0;
        long ret = 1;
        for (int i = n - 2; i <= n; i++) ret *= i;
        return ret / 6;
    }

    private static long comb2(int n) {
        if (n < 2) return 0;
        long ret = 1;
        for (int i = n - 1; i <= n; i++) ret *= i;
        return ret / 2;
    }

    static class DisjointSet {
        DisjointSet parent = this;
        int size = 1;

        DisjointSet findParent() {
            if (parent != this) {
                parent = parent.findParent();
            }
            return parent;
        }

        void union(DisjointSet other) {
            if (other == this) return;

            DisjointSet root = findParent();
            DisjointSet otherRoot = other.findParent();

            if (otherRoot == root) return;

            otherRoot.parent = root;
            root.size += otherRoot.size;

            // // union by size is not really needed as we are not merging the sets
            // if (root.size >= otherRoot.size) {
            //     otherRoot.parent = root;
            //     root.size += otherRoot.size;
            // }
            // else {
            //     root.parent = otherRoot;
            //     otherRoot.size += root.size;
            // }
        }
    }
}
