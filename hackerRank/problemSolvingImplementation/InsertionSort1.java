package hackerRank.problemSolvingImplementation;

public class InsertionSort1 {

	static void insertionSort1(int n, int[] arr) {
		int num = arr[n - 1];

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] > num) {
				arr[i + 1] = arr[i];

				for (int j = 0; j < n; j++) {
					System.out.print(arr[j] + " ");
				}
				System.out.println("");
			} else if (arr[i] < num) {
				arr[i + 1] = num;
				for (int j = 0; j < n; j++) {
					System.out.print(arr[j] + " ");
				}
				System.out.println("");
				break;
			}
		}

		if (arr[0] == arr[1] && arr[0] > num) {
			arr[0] = num;
		}
		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 7, 5, 6, 2 };
		insertionSort1(arr.length, arr);
	}

}
