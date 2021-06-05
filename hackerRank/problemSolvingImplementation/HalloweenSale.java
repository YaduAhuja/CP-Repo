package hackerRank.problemSolvingImplementation;

public class HalloweenSale {
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int ret = 0;
        int sum = 0;
        while (sum < s) {
            if (p < m) {
                p = m;
            }
            sum += p;
            if (sum > s) break;
            if (p > m) {
                p -= d;
            }
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(howManyGames(20, 3, 6, 85));
    }
}
