/**
 *  Problem Link : https://www.codechef.com/problems/MAGDOORS
 *  Runtime : 0.16s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MagicalDoors {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String input = br.readLine().trim();
            sb.append(getMinTimes(input)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int getMinTimes(String input) {
        int ret = 0;
        boolean flipped = false;
        for (char c : input.toCharArray()) {
            if (c == '0' && !flipped) {
                ret++;
                flipped = !flipped;
            }
            if (c == '1' && flipped) {
                ret++;
                flipped = !flipped;
            }
        }

        return ret;
    }
}
