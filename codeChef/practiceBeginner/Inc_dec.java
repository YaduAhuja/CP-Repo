package codeChef.practiceBeginner;
import java.util.Scanner;

public class Inc_dec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n%4==0) {
			
			n = n+1;
			System.out.println(n);
		}
		else
		{
			n = n-1;
			System.out.println(n);
		}

	}

}
