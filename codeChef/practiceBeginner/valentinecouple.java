// problem link: https://www.codechef.com/problems/VCOUPLE
package codeChef.practiceBeginner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class valentinecouple {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> boy = new ArrayList<>();
            ArrayList<Integer> girl = new ArrayList<>();
            ArrayList<Integer> total = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                boy.add(sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                girl.add(sc.nextInt());
            }
            Collections.sort(boy, Collections.reverseOrder());
            Collections.sort(girl);
            for (int i = 0; i < n; i++) {
                total.add(boy.get(i) + girl.get(i));
            }
            System.out.println(Collections.max(total));
            t--;
        }
        sc.close();
    }
}
