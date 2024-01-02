/*
 * Find sum of all the subsequences of the array.
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

	public static void findSumOfSubsequences(int index, int sum, List<Integer> list, int[] arr, int n) {
		if(index == n) {
			list.add(sum);
			return;
		}
		
		findSumOfSubsequences(index + 1, sum + arr[index], list, arr, n); //pick

		findSumOfSubsequences(index + 1, sum, list, arr, n); // not pick
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 2, 1};
		List<Integer> list = new ArrayList<Integer>();
		findSumOfSubsequences(0, 0, list, arr, arr.length);
		System.out.print(list);
	}

}
