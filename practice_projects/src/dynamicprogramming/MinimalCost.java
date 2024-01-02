// https://www.codingninjas.com/studio/problems/minimal-cost_8180930

package dynamicprogramming;

import java.util.Arrays;

public class MinimalCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stones = 4;
		int maxThrowableDistance = 2;
		int heights[] = {10, 40, 30, 10};
		System.out.println(minimizeCostUsingRecursion(stones - 1, maxThrowableDistance, heights));
		System.out.println(minimizeCostUsingMemoization(stones - 1, maxThrowableDistance, heights));
		System.out.println(minimizeCostUsingTabulation(stones - 1, maxThrowableDistance, heights));
		//System.out.println(frogJumpUsingTabulationAndSpaceOptimization(steps - 1, heights));
	}
	
	// Time Complexity : O(2^N*K); Space Complexity : O(1)
	public static int minimizeCostUsingRecursion(int n, int k, int heights[]) {
		int jump = 0;
		int minSteps = Integer.MAX_VALUE;
		
		if(n == 0) return 0;
		
		for(int j = 1; j <= k; j++) {
			if (n - j >= 0) {
				jump = minimizeCostUsingRecursion(n-j, k, heights) + Math.abs(heights[n] - heights[n-j]);
				minSteps = Math.min(jump, minSteps);
			}
		}
		
		return minSteps;
	}
	
	// Time Complexity : O(N*K); Space Complexity : O(N)
	public static int minimizeCostUsingMemoization(int n, int k, int heights[]) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		return solveUsingMemoization(dp, n, k, heights);
	}
	
	private static int solveUsingMemoization(int[] dp, int n, int k, int[] heights) {
		int jump = 0;
		int minSteps = Integer.MAX_VALUE;
		
		if(n == 0) return 0;
		
		if(dp[n] != -1) {
			return dp[n];
		}
		
		for(int j = 1; j <= k; j++) {
			if(n - j >= 0) {
				jump = solveUsingMemoization(dp, n-j, k, heights) + Math.abs(heights[n] - heights[n-j]);
				minSteps = Math.min(jump, minSteps);
			}
		}
		
		return minSteps;
	}
	
	
	// Time Complexity : O(N*K); Space Complexity : O(N)
	public static int minimizeCostUsingTabulation(int n, int k, int[] heights) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		dp[0] = 0;
		
		for(int i=1; i<=n; i++) {
			int minSteps = Integer.MAX_VALUE;
			for(int j = 1; j <= k; j++) {
				if(i-j >= 0) {
					int jump = dp[i-j] + Math.abs(heights[i] - heights[i-j]);
					minSteps = Math.min(jump, minSteps);
				}
			}
			dp[i] = minSteps;
		}
		
		return dp[n];
	}
}
