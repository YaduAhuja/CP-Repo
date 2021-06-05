package hackerRank.problemSolvingImplementation;

import java.util.Arrays;

public class EqualizeTheArray {

    static int equalizeArray(int[] arr) {
        Arrays.sort(arr);
        int maxcount = 0;
        int num = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            num = arr[i];
            temp = 0;
            for (int j = i; j < arr.length; j++) {
                if (num == arr[j]) {
                    temp++;
                }

                if (arr[j] > num) {
                    break;
                }
            }
            if (maxcount < temp) {
                maxcount = temp;
            }
        }
        return arr.length - maxcount;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3};

        System.out.println(equalizeArray(arr));
    }
}
