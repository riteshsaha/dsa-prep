package recursion;

import java.util.ArrayList;
import java.util.List;

public class ContiguousArraySubsequences {
		
	// Using two pointers
	public static void findSubsequences(int index, List<Integer> list, int[] arr, int n) {
		if(index == n) {
			// Print out the subsequence
			for(int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + "  ");
			}
			System.out.println();
			return;
		}
		
		list.add(arr[index]); // pick
		findSubsequences(index + 1, list, arr, n);
		list.remove(list.size() - 1); // not pick; remove the recently inserted element
		findSubsequences(index + 1, list, arr, n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 1, 2};
		List<Integer> list = new ArrayList<Integer>();
		findSubsequences(0, list, arr, arr.length);
	}

}
