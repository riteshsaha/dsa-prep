/*
 * Find subsequences when an element in array can appear only once to form a sum.
 */
package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	
	public static void findCombinationsSum2(int index, int target, List<List<Integer>> ans, int[] arr, List<Integer> list) {
		if(target == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}
		
		for(int i = index; i < arr.length; i++) {
			if(i > index && arr[i] == arr[i - 1]) continue;
			if(arr[i] > target) break;
			list.add(arr[i]);
			findCombinationsSum2(i+1, target - arr[i], ans, arr, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 1, 2, 7, 6, 1 , 5};
		int target = 8;
		Arrays.sort(arr);
		List<List<Integer>> ans = new ArrayList<>(); 
		findCombinationsSum2(0, target, ans, arr, new ArrayList<>());
		System.out.print(ans);
	}

}
