/**
 *  Problem Link : https://cses.fi/problemset/task/1084/
 *  Runtime : 0.60s
 */

package cses.sortingAndSearching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Apartments{	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim()," ");
		int apartments[] = new int[m];
		int customers[] = new int[n];
		for(int i = 0; i < customers.length; i++)customers[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i < apartments.length; i++) apartments[i] = Integer.parseInt(st.nextToken());
		br.close();
		System.out.println(getApplicants(apartments, customers, k));
	}

	private static int getApplicants(int []apartments, int[] customers, int k){
		sort(apartments);
		sort(customers);
		int count = 0;
		
		for(int cptr = 0, aptr = 0; aptr < apartments.length && cptr < customers.length;){
			if(apartments[aptr] <= customers[cptr]+k && apartments[aptr] >= customers[cptr]-k){
				aptr++;
				cptr++;
				count++;
			}else if(customers[cptr] < apartments[aptr]- k)cptr++;
			else aptr++;
		}

		return count;
	}

	// Heap Sort For Faster Sorting than Arrays.sort
	private static void sort(int arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
