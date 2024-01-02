/*
 * Find subsequences when an element in array can appear multiple times to form a sum.
 * 
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
		
	// Using two pointers
	public static void findCombinations(int index, int[] arr, List<List<Integer>> ans, int target, List<Integer> ds) {
		if(index == arr.length) {
			if(target == 0) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}
		
		if(arr[index] <= target) {
			ds.add(arr[index]);
			findCombinations(index, arr, ans, target - arr[index], ds); //pick
			ds.remove(ds.size() - 1);
		}
		findCombinations(index + 1, arr, ans, target, ds);	//not pick
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,6,7};
		int target = 7;
		
		List<List<Integer>> ans = new ArrayList<>();
		findCombinations(0, arr, ans, target, new ArrayList<Integer>());
		//print the list of subsequences
		System.out.print(ans);
	}

}
