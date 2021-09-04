/**
 *  Problem Link : https://codeforces.com/contest/1556/problem/B
 *  Runtime : 0.280s
 */

package codeForces.problemSet.rank1300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TakeYourPlaces {
	private static final long INF = (long) 1e14;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = nextIntArray(n, br);
			sb.append(getOps(arr)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static long getOps(int arr[]){
		if(arr.length <= 1) return 0;
 
		PriorityQueue<Integer> evenNums = new PriorityQueue<>();
		PriorityQueue<Integer> oddNums = new PriorityQueue<>();
 
		for(int i = 0; i < arr.length; i++){
			if(arr[i]%2 == 0) evenNums.add(i);
			else oddNums.add(i);
		}
 
		if(Math.abs(evenNums.size() - oddNums.size()) > 1) return -1;
	
		long ret = INF;
		for(int i = 0; i < 2; i++){
			long cur = 0; int temp = 0;
			int tempArr[] = Arrays.copyOf(arr, arr.length);

			PriorityQueue<Integer> dummyEven = new PriorityQueue<>(evenNums);
			PriorityQueue<Integer> dummyOdd = new PriorityQueue<>(oddNums);

			if(i%2 == 0 && arr[0]%2 != 0){
				temp = dummyEven.remove();
				dummyOdd.add(temp);
			}else if(i%2 != 0 && arr[0]%2 != 1){
				temp = dummyOdd.remove();
				dummyEven.add(temp);
			}

			cur += temp;
			swap(tempArr, 0, temp);

			cur = getOpsValue(dummyEven, dummyOdd, tempArr, temp, cur);

			ret = Math.min(ret, cur);
		}

		return ret;
	}

	private static long getOpsValue(PriorityQueue<Integer> dummyEven, PriorityQueue<Integer> dummyOdd, int tempArr[], int temp, long cur ){
		for(int j = 1; j < tempArr.length; j++){
				
			while(!dummyEven.isEmpty() && dummyEven.peek() <= j) dummyEven.remove();
			while(!dummyOdd.isEmpty() && dummyOdd.peek() <= j) dummyOdd.remove();
			
			if(tempArr[j-1]%2 == tempArr[j]%2){
				if(tempArr[j]%2 == 0){
					if(dummyOdd.isEmpty()) return INF;
					temp =  dummyOdd.remove();
					dummyEven.add(temp);
				}else{
					if(dummyEven.isEmpty()) return INF;
					temp = dummyEven.remove();
					dummyOdd.add(temp);
				}

				cur += Math.abs(j-temp);
				swap(tempArr, j, temp);
			}
		}

		return cur;
	}
	
	private static void swap(int arr[], int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
