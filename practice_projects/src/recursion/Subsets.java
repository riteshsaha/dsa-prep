/*
 * Find all the non-duplicate subsets of an array.
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public static void findNonDuplicateSubsets(int index, int[] arr, List<List<Integer>> ans, List<Integer> list) {
		ans.add(new ArrayList<Integer>(list));
		for(int i = index; i < arr.length; i++) {
			if(i > index && arr[i] == arr[i-1]) continue;
			list.add(arr[i]);
			findNonDuplicateSubsets(index+1, arr, ans, list);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 2};
		List<List<Integer>> ans = new ArrayList<>();
		findNonDuplicateSubsets(0, arr, ans, new ArrayList<Integer>());
		System.out.print(ans);
	}

}
