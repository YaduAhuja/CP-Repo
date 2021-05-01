package hackerRank.problemSolvingImplementation;

public class SaveThePrisoner {

	static int saveThePrisoner(int n, int m, int s) {

		int mod = (m % n + s - 1) % n;

		if (mod == 0) {
			return n;
		} else {
			return mod;
		}

	}

	public static void main(String[] args) {
		int n = 999999999;
		int m = 999999999;
		int s = 1;
		System.out.println(saveThePrisoner(n, m, s));
	}

}
