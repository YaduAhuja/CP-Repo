package hackerRank.problemSolvingImplementation;
import java.util.*;

public class ArrayDS {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] array = scan.nextLine().split(" ");
        scan.close();
        
        while(--n >= 0){
            System.out.print(array[n] + " ");
        }
    }
}
