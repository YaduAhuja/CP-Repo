/**
 *  Problem Link : https://atcoder.jp/contests/abc217/tasks/abc217_a
 *  Runtime : 0.119s
 */
package atCoder.beginner217;

import java.util.Scanner;

public class LexicographicalOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s1 = sc.next();
        sc.close();

        if (isSmaller(s, s1)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isSmaller(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) < t.charAt(i)) return true;
            else if (s.charAt(i) > t.charAt(i)) return false;
        }

        if (s.length() < t.length()) return true;
        return false;
    }
}
