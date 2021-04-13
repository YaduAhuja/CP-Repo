package hackerRank.problemSolvingImplementation;

import java.util.LinkedList;

public class CircularArrayRotation {

	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int[] ret = new int[queries.length];
		LinkedList<Integer> ll = new LinkedList<Integer>();

		for (int i = 0; i < a.length; i++) {
			ll.add(a[i]);
		}

		for (int i = 0; i < k; i++) {
			Integer num = ll.removeLast();
			ll.addFirst(num);
		}

		int[] temp = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			temp[i] = ll.removeFirst();
		}

		for (int i = 0; i < queries.length; i++) {
			ret[i] = temp[queries[i]];
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3 };
		int queries[] = { 0, 1, 2 };
		int k = 2;

		int ret[] = circularArrayRotation(a, k, queries);
		for (int c : ret) {
			System.out.println(c);
		}
	}

}
