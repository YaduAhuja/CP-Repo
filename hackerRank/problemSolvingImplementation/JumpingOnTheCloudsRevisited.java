package hackerRank.problemSolvingImplementation;

public class JumpingOnTheCloudsRevisited {

    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int step = 0;
        if (c[0] == 1) {
            energy -= 2;
        }
        while (energy != 0) {
            step += k;
            if (step % c.length == 0) {
                energy--;
                break;
            } else {
                if (c[step % c.length] == 0) {
                    energy--;
                } else if (c[step % c.length] == 1) {
                    energy -= 3;
                }
            }
        }
        return energy;
    }

    public static void main(String[] args) {

        int c[] = {0, 0, 1, 0};
        System.out.println(jumpingOnClouds(c, 2));
    }
}
