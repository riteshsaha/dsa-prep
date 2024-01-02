// https://leetcode.com/problems/single-number

package bitmanipulation;

public class SingleNumberInArray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,1};
		System.out.println(singleNumber(nums));
		int[] nums_1 = {4,1,2,1,2};
		System.out.println(singleNumber(nums_1));
	}

	public static int singleNumber(int[] nums){
        // Write your code here.
		int result = 0;
		for(int i : nums) {
			result = result^i;
		}
		return result;
    }
}
