package hackerRank.problemSolvingImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class CutTheSticks {

	static int[] cutTheSticks(int[] arr) {
		Arrays.sort(arr);
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			ll.add(arr[i]);
		}
		ArrayList<Integer> aList = new ArrayList<Integer>();
		while (ll.size() > 0) {
			int num = ll.getFirst();
			ListIterator<Integer> itr = ll.listIterator(0);
			int count = 0;
			while (itr.hasNext()) {
				Integer it = itr.next();
				count++;
				if (it - num == 0) {
					itr.remove();
				} else {
					itr.set(it - num);
				}
			}
			aList.add(count);
		}
		int ret[] = new int[aList.size()];
		for (int i = 0; i < aList.size(); i++) {
			ret[i] = aList.get(i);
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 3, 3, 2, 1 };
		int ret[] = cutTheSticks(arr);

		for (int c : ret) {
			System.out.println(c);
		}
	}

}
