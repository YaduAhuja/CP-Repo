package hackerRank.problemSolvingImplementation;

public class BeautifulDaysAtMovie {

	static int reverser(int n) {
		int count = 0;
		while (n != 0) {
			int temp = n % 10;
			n /= 10;
			if (count == 0) {
				count += temp;
			} else {
				count *= 10;
				count += temp;
			}
		}
		return count;
	}

	static int beautifulDays(int i, int j, int k) {
		int count = 0;
		for (; i <= j; i++) {
			int t = reverser(i);
			if (Math.abs(i - t) % k == 0) {
				count++;
			}
		}

		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(beautifulDays(20, 23, 6));
	}

}
