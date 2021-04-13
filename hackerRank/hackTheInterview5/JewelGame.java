package hackerRank.hackTheInterview5;

import java.util.ArrayDeque;
import java.util.Stack;

public class JewelGame {

	public static int getMaxScore(String jewels) {
		Stack<Character> ls = new Stack<>();
		int count = 0;
		for (int i = 0; i < jewels.length(); i++) {
			if (ls.isEmpty()) {
				ls.add(jewels.charAt(i));
			} else if (ls.peek() == jewels.charAt(i)) {
				ls.pop();
				count++;
			} else {
				ls.add(jewels.charAt(i));
			}
		}
		String string = "";
		for (int i = 0; i < ls.size(); i++) {
			string += ls.pop();
		}
		ArrayDeque<Character> j = new ArrayDeque<Character>();
		j.add('d');
		j.add('w');
		j.add('q');
		System.out.println(j);
		System.out.println(j.toString());
		System.out.println(string);
		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string = "abcddcbd";
		System.out.println(getMaxScore(string));

		System.out.println(string);
	}

}
