
// problem link : https:www.codechef.com/problems/ICPC16A

package codeChef.practiceBeginner;
import java.util.Scanner;

public class Helplostrobot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++) {
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			if (y1 == y2 && x2 > x1) {
	            System.out.println("right");
	        } else if (x1 == x2 && y2 > y1) {
	            System.out.println("up");
	        } else if (y1 == y2 && x1 > x2) {
	            System.out.println("left");
	        } else if (x1 == x2 && y2 < y1) {
	             System.out.println("down");
	        } else {
	        	System.out.println("sad");
	        }
		}

	}

}
