package hackerRank.hackTheInterview5;

public class XorProblem {

	public static String maxXorValue(String x, int k) {
		// Write your code here
		String s = "";
		int count = 0;
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == '0' && count < k) {
				s += '1';
				count++;
			} else {
				s += '0';
			}
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(maxXorValue("01010", 1));
	}

}
