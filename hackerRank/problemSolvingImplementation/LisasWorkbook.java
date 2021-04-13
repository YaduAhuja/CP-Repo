package hackerRank.problemSolvingImplementation;

public class LisasWorkbook {
	static int workbook(int n, int k, int[] arr) {
		int ret = 0;
		int page = 0;
		for (int i = 0; i < arr.length; i++) {
			page++;
			for (int j = 1; j <= arr[i]; j++) {
				if ((j - 1) % k == 0 && j != 1) {
					page++;
				}
				if (j == page) {
					ret++;
				}
			}
		}

		return ret;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 4, 2, 6, 1, 10 };// ans 5
		System.out.println(workbook(5, 3, arr));
	}

}
