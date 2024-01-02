// https://leetcode.com/problems/house-robber/

package dynamicprogramming;

import java.util.Arrays;

public class MaxSumOfNonAdjacentNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int houses[] = {1, 2, 3, 1};
		System.out.println(robUsingRecursion(houses));
		System.out.println(robUsingMemoization(houses));
		System.out.println(robUsingTabulation(houses));
		System.out.println(robUsingTabulationAndSpaceOptimization(houses));
	}
	
	// Time Complexity : O(2^N); Space Complexity : O(1)
	public static int robUsingRecursion(int[] nums) {
		return solveUsingRecursion(nums.length - 1, nums);
	}
	
	private static int solveUsingRecursion(int index, int[] nums) {
		// base conditions
		if(index < 0) return 0;
		if(index == 0) return nums[index];
		
		// If element is picked, check for element next to its adjacent element
		int pick = nums[index] + solveUsingRecursion(index - 2, nums);
		
		// If element is not picked, check for adjacent element
		int notPick = 0 + solveUsingRecursion(index - 1, nums);
		
		return Math.max(pick, notPick);
	}
	
	
	// Time Complexity : O(N); Space Complexity : O(N)
	public static int robUsingMemoization(int nums[]) {
		int dp[] = new int[nums.length];
		Arrays.fill(dp, -1);
		
		return solveUsingMemoization(dp, nums.length - 1, nums);
	}
	
	private static int solveUsingMemoization(int[] dp, int index, int[] nums) {
		// base conditions
		if(index < 0) return 0;
		if(index == 0) return nums[index];
		
		if(dp[index] != -1) return dp[index];
		
		int pick = nums[index] + solveUsingMemoization(dp, index - 2, nums);
		int notPick = 0 + solveUsingMemoization(dp, index - 1, nums);
		
		return Math.max(pick, notPick);
	}
	
	
	// Time Complexity : O(N); Space Complexity : O(N)
	public static int robUsingTabulation(int[] nums) {
		int dp[] = new int[nums.length];
		Arrays.fill(dp, -1);
		
		dp[0] = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			int pick = nums[i];
			
			if(i > 1) {
				pick = pick + dp[i-2];
			}
			
			int notPick = dp[i-1];
			
			dp[i] = Math.max(pick, notPick);
		}
		
		return dp[nums.length - 1];
	}
		
	// Time Complexity : O(N); Space Complexity : O(1)
	public static int  robUsingTabulationAndSpaceOptimization(int[] nums) {
		int prev2 = 0, prev = nums[0], curr = 0;
		
		for(int i = 1; i < nums.length; i++) {
			int pick = nums[i];
			
			if(i > 1) {
				pick = pick + prev2;
			}
			
			int notPick = prev;
			curr = Math.max(pick, notPick);
			prev2 = prev;
			prev = curr;
		}
		
		return curr;
	}
}
