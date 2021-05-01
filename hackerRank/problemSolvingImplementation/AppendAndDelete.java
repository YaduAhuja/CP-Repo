package hackerRank.problemSolvingImplementation;

public class AppendAndDelete {

	static String appendAndDelete(String s, String t, int k) {
		if (s.equals(t)) {
			return "Yes";
		}
		char[] s1 = s.toCharArray();
		char[] s2 = t.toCharArray();
		if (s1.length <= s2.length) {
			Integer count = 0;
			for (int i = 0; i < s1.length && i < s2.length; i++) {
				if (s1[i] != s2[i]) {
					count = i;
					break;
				} else {
					count = i;
				}
			}
			count = s1.length - count;
			count += Math.abs(s1.length - s2.length) + count;
			System.out.println(count);
			if (count <= k) {
				return "Yes";
			} else {
				return "No";
			}
		} else {
			Integer count = 0;

			for (int i = 0; i < s2.length; i++) {
				if (s1[i] != s2[i]) {
					count = i;
					break;
				}
			}
			count += s1.length - s2.length;

			System.out.println(count);
			if (count <= k) {
				return "Yes";
			} else {
				return "No";
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(appendAndDelete("Ashley", "Asb", 6));
	}

}
