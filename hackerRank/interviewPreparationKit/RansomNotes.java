package hackerRank.interviewPreparationKit;

import java.util.HashMap;
import java.util.Map;

public class RansomNotes {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> mMap = new HashMap<>();

        for (String s : magazine) {
            if (mMap.containsKey(s)) mMap.put(s, mMap.get(s) + 1);
            else mMap.put(s, 1);
        }
        boolean flag = true;
        for (String s : note) {
            if (mMap.containsKey(s)) {
                if (mMap.get(s) > 0) mMap.put(s, mMap.get(s) - 1);
                else {
                    flag = false;
                    break;
                }
            } else {
                flag = false;
                break;
            }
        }
        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) {
        String magazine[] = "two times three is not four".split(" ");
        String Notes[] = "two times two is four".split(" ");
        checkMagazine(magazine, Notes);
    }
}
