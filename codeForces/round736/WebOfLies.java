/**
 * Problem Link : https://codeforces.com/contest/1549/problem/C
 * Runtime: 0.327s
 */
package codeForces.round736;

import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WebOfLies {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine().trim(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int graph[] = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[min(u, v)]++;
        }

        var sb = new StringBuilder();
        sb.append(solveQueries(graph, br));
        br.close();
        System.out.print(sb);
    }

    private static String solveQueries(int[] graph, BufferedReader br) throws Exception {
        int ret = 0;
        var sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i < graph.length; i++) if (graph[i] == 0) ret++;
        for (int i = 0; i < q; i++) {
            var st = new StringTokenizer(br.readLine().trim(), " ");
            int type = Integer.parseInt(st.nextToken());
            if (type != 3) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    graph[min(a, b)]++;
                    // System.out.println(ret);
                    // System.out.println(min(a, b) +"  "+ graph[min(a, b)]);
                    if (graph[min(a, b)] == 1) ret--;
                    // System.out.println(ret);
                } else if (type == 2) {
                    // System.out.println(min(a, b) +"  "+ graph[min(a, b)]);
                    graph[min(a, b)]--;
                    if (graph[min(a, b)] == 0) ret++;
                }
            } else {
                sb.append(ret).append("\n");
            }
        }
        return sb.toString();
    }
}
