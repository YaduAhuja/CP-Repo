package hackerRank.problemSolvingImplementation;

public class FairRations {
	static int fairRations(int[] B) {
		int count = 0;

		for (int i = 0; i < B.length; i++) {
			if (i != 0 && i < B.length - 1) {
				if (B[i] % 2 != 0 && B[i + 1] % 2 != 0) {
					B[i]++;
					B[i + 1]++;
					count += 2;
				} else if (B[i] % 2 != 0 && B[i - 1] % 2 != 0) {
					B[i]++;
					B[i + 1]++;
					count += 2;
				} else if (B[i] % 2 != 0) {
					B[i]++;
					B[i + 1]++;
					count += 2;
				}
			} else if (i == 0) {
				if (B[i] % 2 != 0) {
					B[i]++;
					B[i + 1]++;
					count += 2;
				}
			} else if (i == B.length - 1) {
				if (B[i] % 2 != 0 && B[i - 1] % 2 != 0) {
					B[i]++;
					B[i - 1]++;
					count += 2;
				}
			}

			for (int j = 0; j < B.length; j++) {
				System.out.print(B[j] + "	");
			}
			System.out.println();
		}
		if (B[B.length - 1] % 2 != 0) {
			System.out.println("NO");
			count = -1;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] b = { 1, 2 };
		System.out.println(fairRations(b));
	}

}
