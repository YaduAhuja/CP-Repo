/**
 *  Problem Link : https://atcoder.jp/contests/abc218/tasks/abc218_b
 *  Runtime : 0.089s
 */

package atCoder.beginner218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Qwerty {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = Stream.of(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();
 
		var sb = new StringBuilder();
		for(int i : arr)
			sb.append((char)(i+'a'- 1));
		System.out.println(sb);
	}
}
