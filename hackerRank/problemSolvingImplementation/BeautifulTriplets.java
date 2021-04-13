package hackerRank.problemSolvingImplementation;

import java.util.ArrayList;
import java.util.List;

public class BeautifulTriplets {
	static int beautifulTriplets(int d, int[] arr) {
		int ret = 0;
		List<Integer> temp = new ArrayList<Integer>();
		for (int c : arr) {
			temp.add(c);
		}

		for (int c : temp) {
			if (temp.contains(c + d) && temp.contains(c + 2 * d)) {
				ret++;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d[] = { 2, 2, 3, 4, 5 };
		System.out.println(beautifulTriplets(1, d));
	}

}
