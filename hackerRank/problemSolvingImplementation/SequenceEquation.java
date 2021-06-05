package hackerRank.problemSolvingImplementation;

public class SequenceEquation {

    static int[] permutationEquation(int[] p) {
        int ret[] = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            int num = i + 1;
            for (int j = 0; j < p.length; j++) {
                if (p[j] == num) {
                    int findex = j + 1;
                    for (int k = 0; k < p.length; k++) {
                        if (p[k] == findex) {
                            ret[i] = k + 1;
                        }
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int p[] = {4, 3, 5, 1, 2};
        int res[] = permutationEquation(p);

        for (int c : res) {
            System.out.println(c);
        }
    }
}
