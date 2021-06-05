/**
 *  Problem Link : https://leetcode.com/problems/unique-binary-search-trees/
 *  Runtime : 0.00
 */
package leetCode.algorithmsMedium;

import java.util.ArrayList;
import java.util.Arrays;

public class UniqueBST {
    private static ArrayList<Integer> countList = new ArrayList<>(Arrays.asList(1, 1));

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) System.out.println(getUniqueBSTCount(i));
    }

    private static int getUniqueBSTCount(int n) {
        int count = 0;
        if (n < countList.size()) return countList.get(n);
        for (int i = 0; i < Math.ceil((double) n / 2); i++) {
            if (i > n / 2 - 1) count += getUniqueBSTCount(i) * getUniqueBSTCount(n - (i + 1));
            else count += 2 * getUniqueBSTCount(i) * getUniqueBSTCount(n - (i + 1));
        }

        countList.add(count);
        return countList.get(n);
    }
}
