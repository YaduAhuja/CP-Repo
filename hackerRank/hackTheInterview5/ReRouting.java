package hackerRank.hackTheInterview5;

import java.util.ArrayList;
import java.util.List;

public class ReRouting {
	public static int getMinConnectionChange(List<Integer> connection) {
		// Write your code here
		int count = 0;
		int i = 0;
		for (; i < connection.size(); i++) {
			if (i + 1 == connection.get(i)) {
				break;
			} else {
				count++;
			}
		}

		if (count == 0) {
			return connection.size() - 1;
		} else {
			return connection.size() - i;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<>();
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(1);
		l.add(5);
		System.out.println(getMinConnectionChange(l));
	}

}
