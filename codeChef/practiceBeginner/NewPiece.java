/**
 *  Problem Link : https://www.codechef.com/problems/NEWPIECE
 *  Runtime : 0.11s
 */
package codeChef.practiceBeginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewPiece {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] arr = nextIntArray(4, br);
            sb.append(getAns(arr)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int getAns(int[] arr) {
        int x1 = arr[0], y1 = arr[1], x2 = arr[2], y2 = arr[3];
        if (x1 == x2 && y1 == y2) return 0;
        else if ((x1 + y1) % 2 == (x2 + y2) % 2) return 2;

        return 1;
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
