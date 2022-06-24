/**
 * Problem Link : https://codeforces.com/problemset/problem/1551/C
 * Runtime : 0.358s
 */
package codeForces.problemSet.rank1500;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InterestingStory {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String arr[] = new String[n];
            for (int i = 0; i < arr.length; i++) arr[i] = br.readLine().trim();
            sb.append(getMaxWords(arr)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int getMaxWords(String[] arr) {
        int ret = 0;
        char[] character = {'a', 'b', 'c', 'd', 'e'};
        Word[] temp = new Word[arr.length];

        for (int i = 0; i < arr.length; i++) temp[i] = new Word(arr[i]);
        for (int i = 0; i < character.length; i++) {
            if (character[i] == 'a') Arrays.sort(temp, (t1, t2) -> t2.aCount - t1.aCount);
            else if (character[i] == 'b') Arrays.sort(temp, (t1, t2) -> t2.bCount - t1.bCount);
            else if (character[i] == 'c') Arrays.sort(temp, (t1, t2) -> t2.cCount - t1.cCount);
            else if (character[i] == 'd') Arrays.sort(temp, (t1, t2) -> t2.dCount - t1.dCount);
            else Arrays.sort(temp, (t1, t2) -> t2.eCount - t1.eCount);

            ret = max(getWords(temp, character[i]), ret);
        }

        return ret;
    }

    private static int getWords(Word[] arr, char c) {
        int ret = 0, charCount = 0;
        for (int i = 0; i < arr.length; i++, ret++) {
            if (c == 'a') charCount += arr[i].aCount;
            else if (c == 'b') charCount += arr[i].bCount;
            else if (c == 'c') charCount += arr[i].cCount;
            else if (c == 'd') charCount += arr[i].dCount;
            else charCount += arr[i].eCount;

            if (charCount < 1) break;
        }
        return ret;
    }

    static class Word {
        String word;
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0, eCount = 0, tCount = 0;

        Word(String word) {
            this.word = word;
            tCount = word.length();
            for (char c : word.toCharArray()) {
                switch (c) {
                    case 'a':
                        aCount++;
                        break;
                    case 'b':
                        bCount++;
                        break;
                    case 'c':
                        cCount++;
                        break;
                    case 'd':
                        dCount++;
                        break;
                    case 'e':
                        eCount++;
                        break;
                }
            }

            aCount -= (tCount - aCount);
            bCount -= (tCount - bCount);
            cCount -= (tCount - cCount);
            dCount -= (tCount - dCount);
            eCount -= (tCount - eCount);
        }

        public String toString() {
            return word + " " + aCount + " " + bCount + " " + cCount + " " + dCount + " " + eCount;
        }
    }
}
