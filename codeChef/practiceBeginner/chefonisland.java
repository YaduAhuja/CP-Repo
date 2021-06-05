package codeChef.practiceBeginner;

import java.util.Scanner;

public class chefonisland {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0;i<t;i++)
        {
            int x = sc.nextInt();  // total food supply
            int y = sc.nextInt(); //total water supply
            int xr = sc.nextInt(); // 1 day food need
            int yr = sc.nextInt(); // 1 day water need
            int d = sc.nextInt(); //total day

            int foodlast = x/xr;
            int waterlast = y/yr;

            int survive = Math.min( foodlast, waterlast);

            if(survive >= d)
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("no");
            }
            

       }
    }
    
}
