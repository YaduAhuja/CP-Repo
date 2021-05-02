package hackerRank.problemSolvingImplementation;

public class InsertionSort2 {

	static void insertionSort2(int n, int[] arr) {
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int num = arr[i + 1];
				arr[i + 1] = arr[i];
				for (int j = i; j >= 0; j--) {
					if (arr[j] < num) {
						arr[j + 1] = num;
						break;
					} else if (j == 0 && arr[j] > num) {
						arr[j + 1] = arr[j];
						arr[j] = num;
					} else {
						arr[j + 1] = arr[j];
					}
				}
			}
			for (int k = 0; k < n; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 7, 5, 6, 2, 1 };
		insertionSort2(arr.length, arr);
	}

}
