package hackerRank.problemSolvingImplementation;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BiggerIsGreater {
    static String biggerIsGreater(String w) {
        char[] temp = w.toCharArray();
        List<Character> tempList = new LinkedList<>();
        for (char t : temp) {
            tempList.add(t);
        }
        ListIterator<Character> tempIterator = tempList.listIterator();
        tempIterator = tempList.listIterator(tempList.size());
        char check = tempIterator.previous(); // last element
        while (tempIterator.hasPrevious()) {
            char c = tempIterator.previous();
            if (c < check) {
                tempIterator.remove();
                tempIterator = tempList.listIterator(tempList.size());
                tempIterator.add(c);
                break;
            } else {
                check = c;
            }
        }

        StringBuilder sBuilder = new StringBuilder();
        for (Character c : tempList) {
            sBuilder.append(c);
        }
        if (sBuilder.toString().equals(w)) return "no answer";
        else return sBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(biggerIsGreater("abdc")); // acdb
        System.out.println(biggerIsGreater("dkhc")); // hcdk
    }
}
