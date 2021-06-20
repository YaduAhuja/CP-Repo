package atCoder.beginner206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Swappable {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        System.out.println(getSwappable(arr));
    }

    private static long getSwappable(int arr[]) {
        HashMap<Integer, Integer> checked = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            checked.put(arr[i], checked.getOrDefault(arr[i], 0) + 1);
        }

        long ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret += arr.length - checked.get(arr[i]);
        }
        return ret / 2;
    }
}
