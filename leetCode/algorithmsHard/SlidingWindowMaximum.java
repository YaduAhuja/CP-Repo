/**
 *  Problem Link : https://leetcode.com/problems/sliding-window-maximum/
 *  Runtime : 83ms
 */

package leetCode.algorithmsHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	public static void main(String[] args) {
		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		// int arr[] = {1,-1};
		int k = 2;

		System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));

	}

	private static int[] maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> ret = new ArrayList<Integer>();

		Deque<Integer> dq = new LinkedList<>();
		int left = 0;

		for (int i = 0; i < nums.length; i++) {
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
				dq.pollLast();
			dq.add(i);

			if (left > dq.peekFirst())
				dq.pollFirst();

			if (i + 1 >= k) {
				ret.add(nums[dq.peekFirst()]);
				left++;
			}
		}

		return ret.stream().mapToInt(Integer::intValue).toArray();
	}

	private static int[] maxSlidingWindowSlow(int nums[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		ArrayList<Integer> ret = new ArrayList<>();
		int i = 0;
		for (; i < k; i++)
			pq.add(nums[i]);

		ret.add(pq.peek());

		for (; i < nums.length; i++) {
			pq.remove(nums[i - k]);
			pq.add(nums[i]);
			ret.add(pq.peek());
		}

		return ret.stream().mapToInt(Integer::intValue).toArray();
	}
}
