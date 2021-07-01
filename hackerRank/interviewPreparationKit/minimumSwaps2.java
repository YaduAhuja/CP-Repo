/**
 *  Problem Link : https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
package hackerRank.interviewPreparationKit;

public class minimumSwaps2 {
    public static void main(String[] args) {
        int arr[] = {7, 1, 3, 2, 4, 5, 6};
        System.out.println(minimumSwaps(arr));
    }

    static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        // Creating the Position Array
        int indexer[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexer[arr[i] - 1] = i;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int temp = arr[i] - 1;
                // Swapping the real Element to be placed with current element placed
                swap(arr, indexer[i], i);
                // Updating the Position Table
                swap(indexer, i, temp);
                count++;
            }
        }
        return count;
    }
}
