/**
 *  Problem Link : https://leetcode.com/problems/swim-in-rising-water/
 *  Runtime : 0.07s
 *  Memory : 39.2 MB
 *  Faster than 83%, Memory usage beats 40%
 */
package leetCode.algorithmsHard;

import java.util.PriorityQueue;

public class SwimInRisingWater {
    private static int moves[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        // int grid[][] =
        // {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        // int grid[][] = {{0,2}, {1,3}};

        int grid[][] = {{10, 12, 4, 6}, {9, 11, 3, 5}, {1, 7, 13, 8}, {2, 0, 15, 14}};
        System.out.println(swimInWater(grid));
    }

    private static int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        int maxTime = grid[0][0], i = 0, j = 0, N = grid.length;

        while (i < N || j < N) {
            for (int move[] : moves) {
                int nextI = i + move[0], nextJ = j + move[1];
                if (nextI < 0
                        || nextI >= N
                        || nextJ < 0
                        || nextJ >= N
                        || grid[nextI][nextJ] == 5000) continue;

                pq.add(new Pair(grid[nextI][nextJ], nextI, nextJ));
                grid[nextI][nextJ] = 5000;
            }

            Pair next = pq.remove();
            maxTime = Math.max(maxTime, next.val);
            i = next.i;
            j = next.j;
            if (i == N - 1 && j == N - 1) break;
        }

        return maxTime;
    }

    private static class Pair {
        int val, i, j;

        Pair(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
}
