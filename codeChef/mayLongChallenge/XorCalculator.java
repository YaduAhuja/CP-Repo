package codeChef.mayLongChallenge;

import java.util.ArrayList;

public class XorCalculator {
	public static void main(String[] args) {
		int arr[] = new int[20];
		for(int i = 0; i < arr.length; i++){
			arr[i] = calculator(i);
		}

		for(int i = 0; i < arr.length; i++){
			System.out.println(i+"  "+arr[i]);
		}
	}

	private static int calculator(int num){
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < Math.pow(2, num); i++){
			if((i ^ (i+1)) == ((i+2)^(i+3)) ){
				arr.add(i);
			}
		}
		// System.out.println(arr);
		return arr.size();
	}
	
}

