package hackerRank.problemSolvingImplementation;

import java.math.BigInteger;

public class ExtraLongFactorials {

	public static void main(String[] args) {
		BigInteger b = BigInteger.valueOf(1);
		int n = 20;
		for (int i = 1; i <= n; i++) {
			b = b.multiply(BigInteger.valueOf(i));
		}
		System.out.println(b.toString());
	}

}
