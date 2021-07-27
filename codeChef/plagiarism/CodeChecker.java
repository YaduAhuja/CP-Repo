package codeChef.plagiarism;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeChecker {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            br.readLine();
            sb.append(isPossible(br.readLine().trim())).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String isPossible(String s) {
        boolean isPossible = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '9') {
                if (s.length() - i > 11) {
                    isPossible = true;
                }
                break;
            }
        }

        if (isPossible) return "Possible";
        return "Not Possible";
    }
}
