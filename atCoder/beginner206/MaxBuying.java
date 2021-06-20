package atCoder.beginner206;

import java.util.Scanner;

public class MaxBuying {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(maxBuying(n));
	}

	private static String maxBuying(int n){
		n = (int)(n*1.08);
		if(n == 206) return "so-so";
		else if(n < 206) return "Yay!";
		else return ":(";
	}
}
