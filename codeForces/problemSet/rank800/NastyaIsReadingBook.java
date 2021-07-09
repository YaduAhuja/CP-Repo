/**
 * Problem Link : https://codeforces.com/problemset/problem/1136/A
 * Runtime : 0.187s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NastyaIsReadingBook {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int book[][] = new int[n][2];
        for (int i = 0; i < book.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            book[i][0] = Integer.parseInt(st.nextToken());
            book[i][1] = Integer.parseInt(st.nextToken());
        }
        int page = Integer.parseInt(br.readLine().trim());
        br.close();
        int i = 0;
        for (; i < book.length; i++) {
            if (page <= book[i][1]) {
                break;
            }
        }

        System.out.println(n - i);
    }
}
