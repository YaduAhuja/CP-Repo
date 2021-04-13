package hackerRank.hackTheInterview5;

import java.util.ArrayDeque;

public class NewKeyboard {

	public static String receivedText(String s) {

		ArrayDeque<Character> res = new ArrayDeque<Character>();
		ArrayDeque<Character> temp = new ArrayDeque<Character>();

		boolean numlock = true;
		boolean cur = true;
		// true insert end
		// false insert start
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '#') {
				numlock = !numlock;
			} else if (s.charAt(i) == '<') {
				if (!cur) {
					if (!temp.isEmpty()) {
						res.addAll(temp);
						temp.clear();
					}
				} else {
					cur = false;
				}
			} else if (s.charAt(i) == '>') {
				cur = true;
				if (!temp.isEmpty()) {
					res.addAll(temp);
					temp.clear();
				}
			} else if (s.charAt(i) == '*') {
				if (cur) {
					if (!res.isEmpty()) {
						res.removeFirst();
					}
				} else {
					if (!temp.isEmpty()) {
						temp.removeFirst();
					}
				}
			} else {
				if (numlock) {
					if (cur) {
						res.addFirst(s.charAt(i));
					} else {
						temp.addFirst(s.charAt(i));
					}
				} else {
					if ((int) s.charAt(i) < 48 || (int) s.charAt(i) > 57) {
						if (cur) {
							res.addFirst(s.charAt(i));
						} else {
							temp.addFirst(s.charAt(i));
						}
					}
				}
			}
		}
		if (!temp.isEmpty()) {
			res.addAll(temp);
		}
		String retString = "";

		while (!res.isEmpty()) {
			retString += res.removeLast();
		}
		System.out.println(retString);

		return retString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "*He<lo>w";
		// loHew

		System.out.println(receivedText(s));
	}

}
