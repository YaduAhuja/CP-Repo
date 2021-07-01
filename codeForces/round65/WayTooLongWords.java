package codeForces.round65;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WayTooLongWords {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            sb.append(getString(br.readLine().trim())).append("\n");
        }

        br.close();
        System.out.print(sb);
    }

    private static String getString(String s) {
        if (s.length() > 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            sb.append(Integer.toString(s.length() - 2));
            sb.append(s.charAt(s.length() - 1));
            return sb.toString();
        }
        return s;
    }
}
