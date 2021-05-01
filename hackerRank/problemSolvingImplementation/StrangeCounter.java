package hackerRank.problemSolvingImplementation;

public class StrangeCounter {
	static long strangeCounter(long t) {
		long n = 2;
		while (3 * (n - 1) < t)
			n = 2 * n;

		n = (3 * (n - 1) - t + 1);
		return n;
	}

	public static void main(String[] args) {
		System.out.println(strangeCounter(17));
	}

}
