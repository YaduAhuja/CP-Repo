package hackerRank.problemSolvingImplementation;

public class FindDigits {
    static int findDigits(int n) {
        int count = 0;
        int num = n;
        while (num != 0) {
            int temp = num % 10;
            num /= 10;
            if (temp == 0) {
                continue;
            } else if (n % temp == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findDigits(12));
    }
}
