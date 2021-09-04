/**
 *  Problem Link : https://atcoder.jp/contests/abc217/tasks/abc217_b
 *  Runtime : 0.146s
 */

package atCoder.beginner217;

import java.util.Scanner;

public class AtCoderQuiz {
	private static String arr[] = {"ABC", "ARC", "AGC", "AHC"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String s1 = sc.next();
		String s2 = sc.next();
		sc.close();
		printNotFound(s,s1,s2);
	}
 
	private static void printNotFound(String s, String t, String q){
		for(String a: arr){
			if(!s.equals(a) && !q.equals(a) && !t.equals(a)){
				System.out.println(a);
			}
		}
	}
}
