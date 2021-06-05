package codeChef.dsaLearningSeries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefAndFoodStreet {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            int max = 0;
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
                int s = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                max = Math.max(max, getProfit(s, p, v));
            }
            sb.append(max + "\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int getProfit(int s, int p, int v) {
        return (int) Math.floor((float) p / (s + 1)) * v;
    }
}
