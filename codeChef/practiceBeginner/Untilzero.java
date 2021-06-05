
//problem link : https:www.codechef.com/TAW22021/problems/TWA221A3

package codeChef.practiceBeginner;

import java.util.Scanner;

public class Untilzero {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			int p = sc.nextInt();
			int q = sc.nextInt();
			int res;

			int c = 1;

			while (p != 0 && q != 0) {
				if (q > p) {
					res = q - p;
					q = res;
					c++;
				} else if (p > q) {
					res = p - q;
					p = res;
					c++;
				} else if (p == q) {
					res = p - q;
					c++;
					break;
				}
			}
			System.out.println(c - 1);
		}
		sc.close();
	}

}
