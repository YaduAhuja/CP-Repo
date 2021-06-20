/**
 *  Problem Link : https://www.spoj.com/problems/TEST/
 *  Runtime : 0.08s
 */
package spoj.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LifeUniverseAndEverything {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = 0;

        while (true) {
            num = Integer.parseInt(br.readLine().trim());
            if (num == 42) break;
            sb.append(num).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
