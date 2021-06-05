package hackerRank.dataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Stream;

public class MergingCommunities {
    public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input[] =
                Stream.of(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<HashSet<Integer>> dsjSets = new ArrayList<>(input[0]);
        for (int i = 0; i < input[0]; i++) {
            dsjSets.add(new HashSet<>());
            dsjSets.get(i).add(i);
        }

        for (int i = 0; i < input[1]; i++) {
            String ret = solveQuery(dsjSets, br.readLine().trim().split(" "));
            if (ret != "") sb.append(ret + "\n");
        }

        br.close();

        System.out.println(sb);
        //		System.out.println(dsjSets);
    }

    private static String solveQuery(ArrayList<HashSet<Integer>> dsjSets, String[] query) {
        if (query[0].equals("Q")) return "" + dsjSets.get(Integer.parseInt(query[1]) - 1).size();
        if (query[0].equals("M"))
            if (dsjSets.get(Integer.parseInt(query[1]) - 1)
                    == dsjSets.get(Integer.parseInt(query[2]) - 1)) return "";

        HashSet<Integer> smallSet = dsjSets.get(Integer.parseInt(query[1]) - 1);
        HashSet<Integer> largeSet = dsjSets.get(Integer.parseInt(query[2]) - 1);

        if (smallSet.size() > largeSet.size()) {
            HashSet<Integer> temp = largeSet;
            largeSet = smallSet;
            smallSet = temp;
        }

        for (int i : smallSet) {
            largeSet.add(i);
            dsjSets.set(i, largeSet);
        }

        return "";
    }
}
