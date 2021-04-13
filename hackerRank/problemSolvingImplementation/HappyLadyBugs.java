package hackerRank.problemSolvingImplementation;

import java.util.HashMap;
import java.util.Map;

public class HappyLadyBugs {
	static String happyLadybugs(String b) {
		char[] init = b.toCharArray();
		int flag = 0;
		Map<Character, Integer> temp = new HashMap<>();
		for (int i = 0; i < init.length; i++) {
			if (init[i] == '_')
				flag = 1;
			if (temp.containsKey(init[i]))
				temp.put(init[i], (temp.get(init[i]) + 1));
			else
				temp.put(init[i], 1);
		}
		temp.remove('_');
		if (temp.containsValue(1)) {
			return "NO";
		} else if (flag == 0) {
			for (int i = 0; i < init.length - 1; i++) {
				if (i == 0) {
					if (init[i] != init[i + 1]) {
						return "NO";
					}
				} else {
					if (init[i] != init[i + 1] && init[i] != init[i - 1]) {
						return "NO";
					}
				}
			}
			return "YES";
		} else {
			return "YES";
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(happyLadybugs("_"));
		System.out.println(happyLadybugs("RBRB"));
		System.out.println(happyLadybugs("RRRR"));
		System.out.println(happyLadybugs("BBB"));
		System.out.println(happyLadybugs("BBB_"));
	}

}
