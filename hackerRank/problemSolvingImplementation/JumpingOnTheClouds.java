package hackerRank.problemSolvingImplementation;

public class JumpingOnTheClouds {

	static int jumpingOnClouds(int[] c) {
		int count = 0;
		int i = 0;

		for (; i < c.length - 2; i++) {
			if (c[i + 2] == 0) {
				System.out.println("+2	" + i);
				count++;
				i++;

			} else {
				System.out.println("+1	" + i);
				count++;
			}
		}

		if (c[c.length - 3] == 1)
			count++;
		return count;
	}

	public static void main(String[] args) {
		int c[] = { 0, 0, 0, 0, 1, 0 };
		System.out.println(jumpingOnClouds(c));
	}

}
