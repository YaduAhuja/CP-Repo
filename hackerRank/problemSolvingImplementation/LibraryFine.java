package hackerRank.problemSolvingImplementation;

public class LibraryFine {
	static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
		int ret = 0;
		if (y1 - y2 > 0) {
			ret = 10000;
		} else if (m1 - m2 > 0 && y2 - y1 == 0) {
			ret = (m1 - m2) * 500;
		} else if (d1 - d2 > 0 && y2 - y1 == 0 && m1 - m2 == 0) {
			ret = (d1 - d2) * 15;
		} else if (y2 - y1 > 0) {
			ret = 0;
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(libraryFine(2, 7, 1014, 2, 1, 1014));
	}

}
