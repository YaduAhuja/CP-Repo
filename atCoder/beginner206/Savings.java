package atCoder.beginner206;

import java.util.Scanner;

public class Savings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(getDays(n));
    }

    private static int getDays(int n) {
        int i = 0;
        for (; i < 100000; i++) {
            if (getSum(i) >= n) break;
        }
        return i;
    }

    // Explicit Formula for the series 0.5*n^2+ 0.5*n
    private static int getSum(int i) {
        return (int) ((double) (i * i) / 2 + (double) i / 2);
    }
}
