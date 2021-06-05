package hackerRank.hackTheInterview5;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class KeyboardOptimized {

    public static void main(String[] args) {
        String str = "*He<*lo>w#5_#1_<_";
        // _loHew_1_
        char ch[] = str.toCharArray();
        List<Character> res = new LinkedList<Character>();
        ListIterator<Character> itr = res.listIterator();
        boolean numlock = true;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '<') {
                itr = res.listIterator(0);
            } else if (ch[i] == '>') {
                int len = res.size();
                itr = res.listIterator(len);
            } else if (ch[i] == '*') {
                if (itr.hasPrevious()) {
                    itr.previous();
                    itr.remove();
                }
            } else if (ch[i] == '#') {
                numlock = !numlock;
            } else {
                if ((int) ch[i] >= 48 && (int) ch[i] <= 57) {
                    if (numlock) {
                        itr.add(ch[i]);
                    }
                } else {
                    itr.add(ch[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : res) {
            sb.append(c);
        }
        String string = sb.toString();
        System.out.println(string);
    }
}
