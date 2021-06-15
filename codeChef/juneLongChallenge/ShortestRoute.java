/**
 *  Problem Link : https://www.codechef.com/JUNE21B/problems/SHROUTE/
 *	Runtime : 1.32s
 */
package codeChef.juneLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *  This Problem can be Solved with 2 Methods one is by Binary Search
 * 	which is implemented in this Solution
 *  and other one is prefix suffix method which is faster than this method
 */
public class ShortestRoute {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            ArrayList<Integer> leftMovingTrains = new ArrayList<>();
            ArrayList<Integer> rightMovingTrains = new ArrayList<>();

            int queries[] = new int[k];
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 0) continue;
                if (x == 1) rightMovingTrains.add(j + 1);
                else leftMovingTrains.add(j + 1);
            }

            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < queries.length; j++) queries[j] = Integer.parseInt(st.nextToken());

            sb.append(serveQueries(queries, leftMovingTrains, rightMovingTrains)).append("\n");
        }

        br.close();
        System.out.print(sb);
    }

    private static StringBuilder serveQueries(
            int queries[],
            ArrayList<Integer> leftMovingTrains,
            ArrayList<Integer> rightMovingTrains) {
        Collections.sort(leftMovingTrains);
        Collections.sort(rightMovingTrains);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < queries.length; i++) {
            if (queries[i] == 1) {
                sb.append("0 ");
                continue;
            }

            int rightIndex = Collections.binarySearch(rightMovingTrains, queries[i]);
            int leftIndex = Collections.binarySearch(leftMovingTrains, queries[i]);

            if (leftIndex >= 0 || rightIndex >= 0) {
                sb.append("0 ");
                continue;
            }

            rightIndex = Math.abs(rightIndex) - 2;
            leftIndex = Math.abs(leftIndex) - 1;
            int nearestLeftTrain = findTrain(leftMovingTrains, leftIndex, true);
            int nearestRightTrain = findTrain(rightMovingTrains, rightIndex, false);

            // System.out.println(nearestLeftTrain +" "+ nearestRightTrain);

            int minTimeLeft =
                    queries[i] > nearestLeftTrain
                            ? Integer.MAX_VALUE
                            : nearestLeftTrain - queries[i];
            int minTimeRight =
                    queries[i] < nearestRightTrain
                            ? Integer.MAX_VALUE
                            : queries[i] - nearestRightTrain;

            // System.out.println(minTimeLeft +" "+ minTimeRight);

            if (minTimeLeft == Integer.MAX_VALUE && minTimeRight == Integer.MAX_VALUE)
                sb.append("-1 ");
            else sb.append(Math.min(minTimeLeft, minTimeRight)).append(" ");
        }

        return sb;
    }

    private static int findTrain(ArrayList<Integer> trains, int index, boolean isLeft) {
        int ret = isLeft ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        try {
            ret = trains.get(index);
        } catch (Exception e) {
        }

        return ret;
    }
}
