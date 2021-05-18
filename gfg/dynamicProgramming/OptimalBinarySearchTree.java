package gfg.dynamicProgramming;

import java.util.Arrays;

public class OptimalBinarySearchTree{
	public static void main(String[] args) {
		int keys[] = {10, 12,13,14};
		int freq[] = {3, 1, 2, 1};
		System.out.println(getMinCost(keys, freq));
	}


	private static int getMinCost(int keys[], int freq[]){
		int dp[][] = new int[keys.length][keys.length];

		//PreProcess
		for(int i = 0; i < dp.length; i++) dp[i][i] = freq[i];


		for(int gap = 1; gap < dp.length; gap++){
			for(int i = 0; i < dp.length-gap; i++){
				int j = gap+i;
				int min = Integer.MAX_VALUE;
				int init = 0;
				for(int x = i; x <= j; x++) init += dp[x][x];

				for(int k = i; k <= j; k++){
					int leftSubtreeCost = k == 0 ? 0 : dp[i][k-1];
					int rightSubtreeCost = k == dp.length-1 ? 0 : dp[k+1][j];
					int subtreeCost = leftSubtreeCost+rightSubtreeCost;
					min = Math.min(subtreeCost,min);
					// System.out.println("Cost Without init for subtree "+i +" "+j+ " using root "+ k +" is "+subtreeCost);
				}

				dp[i][j] = min+ init;
			}
		}

		for(int a[] : dp)System.out.println(Arrays.toString(a));
		return dp[0][dp.length-1];
	}
}