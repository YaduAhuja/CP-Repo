/**
 * Problem Link : https://leetcode.com/problems/longest-consecutive-sequence/
 * Runtime : 50ms
 */
package leetCode.algorithmsMedium;

import java.util.HashMap;
import static java.lang.Math.max;

public class LongestConsecutiveSequence {
    public static void main(String[] args) throws Exception {
        int arr[] = {
            -4, -1, 4, -5, 1, -6, 9, -6, 0, 2, 2, 7, 0, 9, -3, 8, 9, -2, -6, 5, 0, 3, 4, -2
        };
        // int arr[] = {100,4,200,1,3,2};
        // int arr[] = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr));
    }

    private static int longestConsecutive(int[] nums) {
        HashMap<Integer, Cluster> map = new HashMap<>(nums.length);
        int ret = Integer.MIN_VALUE;
        for (int i : nums) map.put(i, new Cluster(i));

        for (int i = 0; i < nums.length; i++) {
            Cluster c = map.get(nums[i]);

            if (map.containsKey(nums[i] - 1)) c.merge(map.get(nums[i] - 1));
            if (map.containsKey(nums[i] + 1)) c.merge(map.get(nums[i] + 1));
            ret = max(ret, c.parent.size);
        }
        return ret;
    }

    private static class Cluster {
        int val, size;
        Cluster parent;

        Cluster(int val) {
            this.val = val;
            this.parent = this;
            this.size = 1;
        }

        Cluster findParent() {
            if (parent == this) return this;
            parent = parent.findParent();
            return parent;
        }

        void merge(Cluster c) {
            parent = findParent();
            c = c.findParent();
            if (parent == c) return;

            parent.size += c.size;
            c.parent = parent;
        }
    }
}
