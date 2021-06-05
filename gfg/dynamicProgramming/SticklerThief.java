package gfg.dynamicProgramming;

public class SticklerThief {
    public static void main(String[] args) {
        int arr[] = {5, 5, 10, 100, 10, 5};
        int n = arr.length;
        System.out.println(FindMaxSum(arr, n));
    }

    private static int FindMaxSum(int arr[], int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 1; i < arr.length; i++) dp[i + 1] = Math.max(dp[i], dp[i - 1] + arr[i]);
        return dp[n];
    }
}
