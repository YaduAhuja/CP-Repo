/**
 * Problem Link : https://leetcode.com/problems/next-permutation/
 * Runtime : 0ms
 */
package leetCode.algorithmsMedium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int arr[], int i) {
        for (int j = arr.length - 1; i < j; i++, j--) {
            swap(arr, i, j);
        }
    }

    private static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0 && nums[i + 1] <= nums[i]; i--)
            ;
        if (i >= 0) {
            int j = nums.length - 1;
            for (; nums[j] <= nums[i]; j--)
                ;
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }
}
