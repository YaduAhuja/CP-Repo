
/**
 *  Problem Link : https://www.codechef.com/problems/STRADJ 
 *	Runtime : 0.13s
 */

package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringGame {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			br.readLine();
			sb.append(getAns(br.readLine().trim())).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	private static String getAns(String s) {
		int count = 0;
		for (char c : s.toCharArray())
			if (c == '0')
				count++;

		count = Math.min(s.length() - count, count);
		if (count == 0)
			return "Bob";
		if (count == 1)
			return "Alice";
		if (s.length() % 2 == 0)
			return "Bob";
		return "Alice";
	}
}
