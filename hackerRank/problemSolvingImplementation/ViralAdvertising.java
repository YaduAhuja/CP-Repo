package hackerRank.problemSolvingImplementation;

public class ViralAdvertising {

    static int viralAdvertising(int n) {
        int count = 2;
        int liked = 2;
        for (int i = 1; i < n; i++) {
            liked = (liked * 3) / 2;
            count += liked;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(viralAdvertising(5));
    }
}
