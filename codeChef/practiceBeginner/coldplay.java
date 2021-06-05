package codeChef.practiceBeginner;

import java.util.Scanner;

public class coldplay {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int s = sc.nextInt();

            int result = m / s;
            System.out.println(result);
        }
        sc.close();
    }
}
