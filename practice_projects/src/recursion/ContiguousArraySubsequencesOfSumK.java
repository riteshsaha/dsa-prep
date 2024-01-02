/*
 * Find subsequences when an element in array can appear only once to form a sum.
 * 
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

public class ContiguousArraySubsequencesOfSumK {
		
	// Using two pointers
	public static void findSubsequencesOfSumK(int index, List<Integer> list, int k, int sum, int[] arr, int n) {
		if(index == n) {
			if(k == sum) {
				// Print out the subsequence having sum k
				for(int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i) + "  ");
				}
				System.out.println();
			}
			return;
		}
		
		list.add(arr[index]); // pick
		k += arr[index];
		findSubsequencesOfSumK(index + 1, list, k, sum, arr, n);
		list.remove(list.size() - 1); // not pick; remove the recently inserted element
		k -= arr[index];
		findSubsequencesOfSumK(index + 1, list, k, sum, arr, n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,1};
		int sum = 2;
		List<Integer> list = new ArrayList<Integer>();
		findSubsequencesOfSumK(0, list, 0, sum, arr, arr.length);
	}

}
