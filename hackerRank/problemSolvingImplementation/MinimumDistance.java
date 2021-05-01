package hackerRank.problemSolvingImplementation;

public class MinimumDistance {
	static int minimumDistances(int[] a) {
		int ret = 1000;
		int minA = 0;
		int minB = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					if (Math.abs(i - j) < ret) {
						ret = Math.abs(i - j);
						minA = i;
						minB = j;
					}
				}
			}
		}
		System.out.println(minA + "    " + minB);
		if (ret == 1000)
			ret = -1;
		return ret;
	}

	public static void main(String[] args) {
		int d[] = { 7, 1, 3, 4, 1, 7 };

		System.out.println(minimumDistances(d));
	}

}
