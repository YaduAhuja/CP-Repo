
//problem link :https:www.codechef.com/problems/T20MCH

package codeChef.practiceBeginner;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class PossibleVictory {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int o = sc.nextInt();
        int c = sc.nextInt();

        int remainingover = 20-o;
        int play = remainingover*6;
        int maxscore = play*6;
        int Totalscore = c + maxscore;

        if(Totalscore > r){

            System.out.println("yes");
        }
        else{

            System.out.println("no");
        }

    }
    
}
