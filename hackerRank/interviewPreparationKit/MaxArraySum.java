package hackerRank.interviewPreparationKit;

public class MaxArraySum {
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 8, 4};
        System.out.println(maxSubsetSum(arr));
    }

    private static int maxSubsetSum(int[] arr) {
        if (arr.length == 1) return arr[0];
        else if (arr.length == 2) return Math.max(arr[0], arr[1]);

        // This solutions Uses Constant Space with bit of time loss for all mod operation
        int sum[] = new int[2];
        sum[0] = arr[0];
        sum[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            sum[i % 2] = Math.max(arr[i], arr[i] + sum[i % 2]);
            if (i % 2 == 1) sum[i % 2] = Math.max(sum[i % 2], sum[(i % 2) - 1]);
            else sum[i % 2] = Math.max(sum[i % 2], sum[(i % 2) + 1]);
        }

        return Math.max(sum[0], sum[1]);
    }
}
