/**
 *  Problem Link : https://cses.fi/problemset/task/1668
 *  Runtime: 0.95s
 *  if you are facing stack overflow error use thread
 */
package cses.graphAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BuildingTeams {
    static boolean visited[];
    static int team[];

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int pupils = Integer.parseInt(st.nextToken());
        int friendships = Integer.parseInt(st.nextToken());
        ArrayList<Integer> graph[] = new ArrayList[pupils];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        visited = new boolean[pupils];
        team = new int[pupils];
        for (int i = 0; i < friendships; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int source = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            graph[source].add(dest);
            graph[dest].add(source);
        }
        br.close();
        System.out.println(getTeams(graph));
    }

    private static String getTeams(ArrayList<Integer> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (!dfs(i, graph, -1)) return "IMPOSSIBLE";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < team.length; i++) sb.append(team[i] + " ");
        return sb.toString();
    }

    private static boolean dfs(int i, ArrayList<Integer> graph[], int parent) {
        if (!visited[i]) {
            visited[i] = true;
            if (parent == -1) team[i] = 1;
            else if (team[parent] == 1) team[i] = 2;
            else team[i] = 1;

            for (int j : graph[i]) {
                if (!dfs(j, graph, i)) return false;
            }

        } else if (parent != -1) if (team[parent] == team[i]) return false;
        return true;
    }
}
