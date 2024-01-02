// https://www.codingninjas.com/studio/problems/two-numbers-with-odd-occurrences_8160466

package bitmanipulation;

public class TwoOddOccurences {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 4, 1, 3, 2, 4};
		int[] nums_1 = {3, 3, 1, 2};
		int[] nums_2 = {1, 2};
		
		int[] res = twoOddNum(nums);
		int[] res_1 = twoOddNum(nums_1);
		int[] res_2 = twoOddNum(nums_2);
		
		for(int i = 0; i < 2; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < 2; i++) {
			System.out.print(res_1[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < 2; i++) {
			System.out.print(res_2[i] + " ");
		}
		System.out.println();
	}

	public static int[] twoOddNum(int []arr){
        // Write your code here.
		int xor = 0;
		int set = 0, unset = 0;
		
		for(int i : arr) {
			xor ^= i;
		}
		
		// Formula to find right most set bit
		int rightMostSetBit = xor & ~(xor - 1);
		
		// One of the two odd numbers will have a set bit in that position and an unset bit at the same position
		// Hence, segregating the array elements based on the above criteria and doing a xor to find the elements
		for(int j : arr) {
			if((j & rightMostSetBit) != 0) {
				set ^= j;
			} else {
				unset ^= j;
			}
		}
		
		return new int[]{Math.max(set, unset), Math.min(set, unset)};
    }
}
