/**
 *  Problem Link : https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 *  Runtime : 0.078s
 */
package leetCode.algorithmsHard;

import java.util.ArrayList;

public class KthAncestorTreeNode {
    private static int[] depth;
    private static int[][] tree;

    public static void main(String[] args) {
        TreeAncestor(10, new int[] {-1, 0, 1, 2, 0, 1, 0, 4, 7, 1});

        System.out.println(getKthAncestor(3, 3));
        System.out.println(getKthAncestor(2, 9));
        System.out.println(getKthAncestor(2, 7));
        System.out.println(getKthAncestor(3, 2));
    }

    private static void TreeAncestor(int n, int[] parent) {
        // finding log base 2 of n
        int log = 0;
        for (; 1 << log < n; log++)
            ;
        // Incrementing for upper bound
        log++;

        tree = new int[n][log];
        depth = new int[n];
        ArrayList<ArrayList<Integer>> adj = getAdjList(parent);
        dfs(adj, 0);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int cur) {
        // Creating Binary Lifted Tree
        for (int i : adj.get(cur)) {
            depth[i] = depth[cur] + 1;
            int log = 0;
            for (; 1 << log < depth[cur]; log++)
                ;
            tree[i][0] = cur;

            for (int j = 1; j < log; j++) {
                tree[i][j] = tree[tree[i][j - 1]][j - 1];
            }

            dfs(adj, i);
        }
    }

    private static ArrayList<ArrayList<Integer>> getAdjList(int[] parent) {
        // Creating adjacency List of Tree
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < parent.length; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) adj.get(parent[i]).add(i);
        }

        return adj;
    }

    private static int getKthAncestor(int node, int k) {
        if (depth[node] < k) return -1;
        int log = 1;

        for (; 1 << log < depth[node]; log++)
            ;
        for (int j = log; j >= 0; j--) {
            if (k >= (1 << j)) {
                node = tree[node][j];
                k -= 1 << j;
            }
        }
        return node;
    }
}
