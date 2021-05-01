package hackerRank.problemSolvingImplementation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ManasaAndStones {
	static int[] stones(int n, int a, int b) {
		Set<Integer> temp = new HashSet<>();
		for (int i = 0; i < n; i++) {
			temp.add(b * i + a * (n - 1 - i));
		}
		int i = 0;
		int[] ret = new int[temp.size()];
		for (int c : temp) {
			ret[i] = c;
			i++;
		}
		Arrays.sort(ret);
		return ret;
	}

	public static void main(String[] args) {
		int[] d = stones(73, 25, 25);

		for (int c : d) {
			System.out.println(c);
		}
	}

}
