package hackerRank.interviewPreparationKit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewYearChaos {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		long t1 = System.currentTimeMillis();
		for(int i = 0; i < t; i++){
			br.readLine();
			minimumBribes(Stream.of(br.readLine().trim().split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
		}
		br.close();
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1 + " ms");
	}

	//1 2 5 3 7 8 6 4
	//0 0 0 1 0 0 2 4
	//1 2 3 4 5 6 7 8
	//0 0 2 0 2 2 0 0
	public static void minimumBribes(List<Integer> q) {
		// Write your code here
		int ret = 0;
		boolean tooChaotic = false;

		for(int i = q.size()-1; i > -1; i--){
			//Check the Displacement of Values from its indexes to check for Chaotic
			if(q.get(i) > (i+1)){
				if(q.get(i) - (i+1) > 2){
					tooChaotic = true;
					break;
				}
			}
			
			//Check the displacement of values from its indexes to check bribe value
			if(i-1 >= 0 && q.get(i-1) == i+1){
				ret++;
				q.set(i-1, q.get(i));
				q.set(i, i+1);
			}
			else if(i-2 >= 0 && q.get(i-2) == i+1){
				ret += 2;
				//Swapping the 3 Numbers
				q.set(i-2, q.get(i-1));
				q.set(i-1, q.get(i));
				q.set(i, i+1);
			}
		}

		if(tooChaotic) System.out.println("Too chaotic");
		else System.out.println(ret);
	}
}
