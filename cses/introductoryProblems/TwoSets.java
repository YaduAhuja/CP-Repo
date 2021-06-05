/**
 *  Problem Link : https://cses.fi/problemset/task/1092/
 *  Runtime : 0.50s
 */
package cses.introductoryProblems;

import java.util.Scanner;

public class TwoSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(canTwoSetsMade(n));
    }

    private static String canTwoSetsMade(int n) {
        double sum = (long) n * (n + 1);
        long ceil = (long) Math.ceil(sum / 2);
        if ((ceil & 1) == 1) return "NO";

        long firstListSum = 0, secondListSum = 0;
        int firstSetCount = 0, secondSetCount = 0;

        StringBuilder firstSet = new StringBuilder();
        StringBuilder secondSet = new StringBuilder();

        for (int i = n; i > 0; i--) {
            if (firstListSum > secondListSum) {
                secondSet.append(i).append(" ");
                secondListSum += i;
                secondSetCount++;
            } else {
                firstSet.append(i).append(" ");
                firstListSum += i;
                firstSetCount++;
            }
        }
        firstSet.append("\n");
        StringBuilder sb = new StringBuilder("YES\n");
        sb.append(firstSetCount + "\n");
        sb.append(firstSet);
        sb.append(secondSetCount + "\n");
        sb.append(secondSet);
        return sb.toString();
    }
}
