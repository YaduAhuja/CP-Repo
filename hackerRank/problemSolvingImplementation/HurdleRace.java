package hackerRank.problemSolvingImplementation;

import java.util.Arrays;

public class HurdleRace {
    static int hurdleRace(int k, int[] height) {
        Arrays.sort(height);
        int x = height[height.length - 1];
        if (k < x) {
            return x - k;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] h = {1, 6, 3, 5, 2};
        int k = 7;

        System.out.println(hurdleRace(k, h));
    }
}
