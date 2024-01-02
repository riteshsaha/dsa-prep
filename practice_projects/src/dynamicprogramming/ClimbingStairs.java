// https://leetcode.com/problems/climbing-stairs/

package dynamicprogramming;

import java.util.Arrays;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairsUsingRecursion(3));
		System.out.println(climbStairsUsingMemoization(3));
		System.out.println(climbStairsUsingTabulation(3));
		System.out.println(climbStairsUsingTabulationAndSpaceOptimization(3));
	}
	
	// Time Complexity : O(2^N); Space Complexity : O(1)
	public static int climbStairsUsingRecursion(int n) {
		if(n == 0) return 1;
		if(n == 1) return 1;
		
		return climbStairsUsingRecursion(n-1) + climbStairsUsingRecursion(n-2);
	}
	
	
	// Time Complexity : O(N); Space Complexity : O(N)
	public static int climbStairsUsingMemoization(int n) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		return solveUsingMemoization(dp, n);
	}
	
	private static int solveUsingMemoization(int[] dp, int n) {		
		if(n <= 1) {
			dp[n] = 1;
			return dp[n];
		}
		
		if(dp[n] == -1) {
			return solveUsingMemoization(dp, n-1) + solveUsingMemoization(dp, n-2);
		} else {
			return dp[n];
		}
	}
	
	
	// Time Complexity : O(N); Space Complexity : O(N)
	public static int climbStairsUsingTabulation(int n) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	// Time Complexity : O(N); Space Complexity : O(1)
	public static int  climbStairsUsingTabulationAndSpaceOptimization(int n) {
		int prev2 = 1, prev = 1, curr = 0;
		
		for(int i = 2; i <= n; i++) {
			curr = prev + prev2;
			prev2 = prev;
			prev = curr;
		}
		
		return curr;
	}
}
