/**
 *  Problem Link : https://atcoder.jp/contests/abc217/tasks/abc217_e
 *  Runtime : 0.493s
 */
package atCoder.beginner217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SortingQueries {
    private static PriorityQueue<Integer> logs = new PriorityQueue<>();
    private static LinkedList<Integer> pending = new LinkedList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();

        for (int j = 0; j < n; j++) {
            var st = new StringTokenizer(br.readLine().trim());
            int type = Integer.parseInt(st.nextToken());
            sb.append(serveQuery(type, st));
        }
        br.close();
        System.out.println(sb);
    }

    private static String serveQuery(int type, StringTokenizer st) {
        if (type == 1) {
            int a = Integer.parseInt(st.nextToken());
            pending.addLast(a);
        } else if (type == 2) {
            if (logs.size() == 0) return pending.removeFirst() + "\n";
            else return logs.remove() + "\n";
        } else {
            logs.addAll(pending);
            pending = new LinkedList<>();
        }
        return "";
    }
}
