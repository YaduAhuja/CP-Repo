package hackerRank.problemSolvingImplementation;

import java.util.ArrayList;

public class KaprekarNumbers {

    static void kaprekarNumbers(int p, int q) {
        ArrayList<Long> aList = new ArrayList<Long>();
        for (int i = p; i <= q; i++) {
            String num = String.valueOf((long) Math.pow(i, 2));
            if (num.length() > 1) {
                int index = num.length() / 2;
                long x = Long.valueOf(num.substring(0, index));
                long y = Long.valueOf(num.substring(index));

                if (x + y == i) {
                    aList.add((long) i);
                }
            } else {
                if (Integer.parseInt(num) == i) {
                    aList.add((long) i);
                }
            }
        }

        if (aList.size() == 0) {
            System.out.println("INVALID RANGE");
        } else {
            for (Long c : aList) {
                System.out.print(c + " ");
            }
        }
    }

    public static void main(String[] args) {
        kaprekarNumbers(1, 100);
    }
}
