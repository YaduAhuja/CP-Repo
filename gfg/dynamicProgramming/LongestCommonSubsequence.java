/**
 *  Runtime : 0.35s
 */
package gfg.dynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int A = 6, B = 6;
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(lcs(A, B, s1, s2));
    }

    private static int lcs(int x, int y, String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int j = 1; j < dp[0].length; j++) {
            for (int i = 1; i < dp.length; i++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
