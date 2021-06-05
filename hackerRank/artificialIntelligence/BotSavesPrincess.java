package hackerRank.artificialIntelligence;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BotSavesPrincess {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gridSize = Integer.parseInt(br.readLine().trim());
        char grid[][] = new char[gridSize][gridSize];
        int botx = -1, boty = -1, prinx = -1, priny = -1;
        for (int i = 0; i < grid.length; i++) {
            String row = br.readLine().trim();
            assert row.length() == gridSize;
            for (int j = 0; j < grid[0].length; j++) {
                if (row.charAt(j) == 'm') {
                    botx = j;
                    boty = i;
                } else if (row.charAt(j) == 'p') {
                    prinx = j;
                    priny = i;
                }
            }
        }
        br.close();

        System.out.println(rlActions(boty - priny, botx - prinx));
    }

    private static String rlActions(int verticalConfig, int horizontalConfig) {
        StringBuilder sb = new StringBuilder();
        if (verticalConfig < 0) {
            while (verticalConfig < 0) {
                sb.append("DOWN" + "\n");
                verticalConfig++;
            }
        }

        if (horizontalConfig < 0) {
            while (horizontalConfig < 0) {
                sb.append("RIGHT" + "\n");
                horizontalConfig++;
            }
        }

        if (verticalConfig > 0) {
            while (verticalConfig > 0) {
                sb.append("UP" + "\n");
                verticalConfig--;
            }
        }

        if (horizontalConfig > 0) {
            while (horizontalConfig > 0) {
                sb.append("LEFT" + "\n");
                horizontalConfig--;
            }
        }

        return sb.toString();
    }
}
