package hackerRank.problemSolvingImplementation;

import java.util.Arrays;

public class OrganizingContainersOfBalls {
	static String organizingContainers(int[][] container) {
		String ret = "Possible";
		int[] containers = new int[container.length];
		int[] balls = new int[container.length];
		for (int i = 0; i < container.length; i++) {
			for (int j = 0; j < container.length; j++) {
				containers[i] += container[i][j];
				balls[j] += container[i][j];
			}
		}
		Arrays.sort(balls);
		Arrays.sort(containers);

		for (int c : balls) {
			System.out.print(c + " ");
		}
		System.out.println();
		for (int c : containers) {
			System.out.print(c + " ");
		}
		System.out.println();
		for (int i = 0; i < container.length; i++) {
			if (containers[i] != balls[i]) {
				ret = "Impossible";
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int d[][] = { { 1, 1 }, { 1, 1 } };
		System.out.println(organizingContainers(d));
	}

}
