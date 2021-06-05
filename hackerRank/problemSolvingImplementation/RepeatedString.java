package hackerRank.problemSolvingImplementation;

public class RepeatedString {
    static long repeatedString(String s, long n) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        count *= n / s.length();
        String sub = s.substring(0, (int) (n % s.length()));

        // System.out.println(sub + " " + n % s.length());
        for (int i = 0; i < sub.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("ava", 10));
    }
}
