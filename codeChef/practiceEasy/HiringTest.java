package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HiringTest {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringBuilder ts = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int c = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine().trim(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = 0; j < c; j++) {
                if (willPass(br.readLine().trim(), x, y)) ts.append('1');
                else ts.append('0');
            }
            sb.append(ts + "\n");
        }

        br.close();
        System.out.println(sb.toString());
    }

    private static boolean willPass(String attempt, int x, int y) {
        int fCount = 0, pCount = 0;
        for (int i = 0; i < attempt.length(); i++) {
            if (attempt.charAt(i) == 'F') fCount++;
            else if (attempt.charAt(i) == 'P') pCount++;
        }

        if (fCount >= x) return true;
        if (fCount == x - 1 && pCount >= y) return true;
        return false;
    }
}
