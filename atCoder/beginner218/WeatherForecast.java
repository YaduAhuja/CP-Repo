/**
 *  Problem Link : https://atcoder.jp/contests/abc218/tasks/abc218_a
 *  Runtime : 0.114s
 */
package atCoder.beginner218;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WeatherForecast {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        br.close();
        if (s.charAt(n - 1) == 'o') System.out.println("Yes");
        else System.out.println("No");
    }
}
