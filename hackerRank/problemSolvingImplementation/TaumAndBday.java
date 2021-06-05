package hackerRank.problemSolvingImplementation;

public class TaumAndBday {

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        long blackb = (long) b;
        long whiteb = (long) w;
        long blackc = (long) bc;
        long whitec = (long) wc;
        long conversion = (long) z;
        long ret = 0;
        if (Math.abs(blackc - whitec) > conversion) { // conversion is beneficial
            if (Math.min(blackc, whitec) == wc) { // White Cost is less
                ret += blackb * (whitec + conversion);
                ret += whiteb * whitec;
            } else {
                ret += whiteb * (blackc + conversion);
                ret += blackb * blackc;
            }
        } else {
            ret += blackb * blackc;
            ret += whiteb * whitec;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(taumBday(27984, 1402, 619246, 615589, 247954));
    }
}
