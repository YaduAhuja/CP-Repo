package hackerRank.problemSolvingImplementation;

public class SherlockAndSquares {

	static int squares(int a, int b) {
		int count = 0;
		int s = (int) Math.ceil(Math.sqrt(a));
		for (int i = s; Math.pow(i, 2) <= b; i++) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(squares(17, 24));
	}

}
