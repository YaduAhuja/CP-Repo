package codeChef.practiceBeginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GudduOnDate {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) sb.append(getSum(Long.parseLong(br.readLine().trim())) + "\n");
        br.close();
        System.out.println(sb);
    }

    private static String getSum(long i) {
        if (i < 1) return "0";
        long c = i, ans = 0;
        int ctr = 0;
        for (; c > 0; ans += c % 10, c /= 10)
            ;
        for (; ans % 10 != 0; ctr++, ans++)
            ;
        return i + "" + ctr;
    }
}
