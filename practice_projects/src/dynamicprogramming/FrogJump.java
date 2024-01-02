// https://www.codingninjas.com/studio/problems/frog-jump_3621012

package dynamicprogramming;

import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int steps = 4;
		int heights[] = {10, 20, 30, 10};
		System.out.println(frogJumpUsingRecursion(steps - 1, heights));
		System.out.println(frogJumpUsingMemoization(steps - 1, heights));
		System.out.println(frogJumpUsingTabulation(steps - 1, heights));
		System.out.println(frogJumpUsingTabulationAndSpaceOptimization(steps - 1, heights));
	}
	
	// Time Complexity : O(2^N); Space Complexity : O(1)
	public static int frogJumpUsingRecursion(int n, int heights[]) {
		int jumpOneStep = 0;
		int jumpTwoSteps = Integer.MAX_VALUE;
		
		if(n == 0) return 0;
		
		jumpOneStep = frogJumpUsingRecursion(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
		
		if(n > 1) {
			jumpTwoSteps = frogJumpUsingRecursion(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
		}
		
		return Math.min(jumpOneStep, jumpTwoSteps);
	}
	
	
	// Time Complexity : O(N); Space Complexity : O(N)
	public static int frogJumpUsingMemoization(int n, int heights[]) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		return solveUsingMemoization(dp, n, heights);
	}
	
	private static int solveUsingMemoization(int[] dp, int n, int[] heights) {
		int jumpOneStep = 0;
		int jumpTwoSteps = Integer.MAX_VALUE;
		
		if(n == 0) {
			return 0;
		}
		
		if(dp[n] == -1) {
			jumpOneStep = solveUsingMemoization(dp, n-1, heights) + Math.abs(heights[n] - heights[n-1]);
			
			if(n > 1) {
				jumpTwoSteps = solveUsingMemoization(dp, n-2, heights) + Math.abs(heights[n] - heights[n-2]);
			}
			
			return Math.min(jumpOneStep, jumpTwoSteps);
		} else {
			return dp[n];
		}
	}
	
	
	// Time Complexity : O(N); Space Complexity : O(N)
	public static int frogJumpUsingTabulation(int n, int[] heights) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		dp[0] = 0;
		
		for(int i=1; i<=n; i++) {
			int jumpOneStep = 0;
			int jumpTwoSteps = Integer.MAX_VALUE;
			
			jumpOneStep = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
			
			if(i > 1) {
				jumpTwoSteps = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
			}
			
			dp[i] = Math.min(jumpOneStep, jumpTwoSteps);
		}
		
		return dp[n];
	}
	
	
	// Time Complexity : O(N); Space Complexity : O(1)
	public static int  frogJumpUsingTabulationAndSpaceOptimization(int n, int[] heights) {
		int prev2 = 0, prev = 0, curr = 0;
		
		for(int i = 1; i <= n; i++) {
			int jumpOneStep = 0;
			int jumpTwoSteps = Integer.MAX_VALUE;
			
			jumpOneStep = prev + Math.abs(heights[i] - heights[i-1]);
			
			if(i > 1) {
				jumpTwoSteps = prev2 + Math.abs(heights[i] - heights[i-2]);
			}
			
			curr = Math.min(jumpOneStep, jumpTwoSteps);
			prev2 = prev;
			prev = curr;
		}
		
		return curr;
	}
}
