package hackerRank.problemSolvingImplementation;

public class UtopianTree {
	static int utopianTree(int n) {
		int ret = 1;
		if (n == 0) {
			return 1;
		} else {
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0) {
					ret++;
				} else {
					ret *= 2;
				}
			}
			return ret;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(utopianTree(5));
	}

}
