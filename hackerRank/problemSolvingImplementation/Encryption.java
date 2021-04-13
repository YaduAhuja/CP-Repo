package hackerRank.problemSolvingImplementation;

import java.util.ArrayList;
import java.util.List;

public class Encryption {
	static String encryption(String s) {
		char[] temp = s.toCharArray();
		int column = (int) Math.ceil(Math.sqrt(temp.length));
		int row = (int) Math.floor(Math.sqrt(temp.length));
		int num = 0;
		System.out.println(row + "\n" + column);
		if (row * column < temp.length) {
			row++;
		}
		if (row > column) {
			return "error";
		}
		List<Character> retlist = new ArrayList<Character>();
		for (int i = 0; i < column; i++) {
			for (int k = 0; k < row; k++) {
				num = (column * k) + i;
				if (num < temp.length) {
					retlist.add(temp[num]);
				}
			}
			retlist.add(' ');
		}
		StringBuilder sb = new StringBuilder();
		for (char c : retlist) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(encryption("aka"));
	}

}
