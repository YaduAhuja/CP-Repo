package hackerRank.artificialIntelligence;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BotSavesPrincess2 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        br.readLine();
        char[][] inp = new char[n][n];

        for (int i = 0; i < n; i++) inp[i] = br.readLine().trim().toCharArray();
        br.close();

        nextMove(inp);
    }

    private static void nextMove(char[][] inp) {
        int bi = -1, bj = -1, pi = -1, pj = -1;
        for (int i = 0; i < inp.length; i++) {
            for (int j = 0; j < inp[0].length; j++) {
                if (inp[i][j] == 'm') {
                    bi = i;
                    bj = j;
                } else if (inp[i][j] == 'p') {
                    pi = i;
                    pj = j;
                }
            }
        }

        if (bi == -1 || bj == -1 || pi == -1 || pj == -1)
            System.out.println("Error in coordinates");
        else System.out.println(performMove(bi, bj, pi, pj));
    }

    private static String performMove(int bi, int bj, int pi, int pj) {
        if (bi - pi > 0) return "UP";
        else if (bi - pi < 0) return "DOWN";
        else if (bj - pj > 0) return "LEFT";
        else return "RIGHT";
    }
}
