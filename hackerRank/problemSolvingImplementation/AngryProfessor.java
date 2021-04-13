package hackerRank.problemSolvingImplementation;

public class AngryProfessor {
	static String angryProfessor(int k, int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= 0) {
				count++;
			}
		}
		if (count >= k) {
			return "NO";
		} else {
			return "YES";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 2;
		int[] a = { -1, 0, 1, 2 };
		System.out.println(angryProfessor(k, a));
	}

}
