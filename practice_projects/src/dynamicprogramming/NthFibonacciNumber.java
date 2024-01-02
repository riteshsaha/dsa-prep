// https://www.codingninjas.com/studio/problems/nth-fibonacci-number_74156

package dynamicprogramming;

import java.util.Arrays;

public class NthFibonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findFibUsingRecursion(6));
		System.out.println(findFibUsingMemoization(6));
		System.out.println(findFibUsingTabulation(6));
		System.out.println(findFibUsingTabulationAndSpaceOptimization(6));
	}
	
	// Time Complexity : O(2^N); Space Complexity : O(1)
	public static int findFibUsingRecursion(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return findFibUsingRecursion(n-1) + findFibUsingRecursion(n-2);
	}
	
	// Time Complexity : O(N); Space Complexity : O(N)
	public static int findFibUsingMemoization(int n) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		return solveUsingMemoization(dp, n);
	}
	
	private static int solveUsingMemoization(int[] dp, int n) {		
		if(n <= 1) return n;
		
		if(dp[n] == -1) {
			return solveUsingMemoization(dp, n-1) + solveUsingMemoization(dp, n-2);
		} else {
			return dp[n];
		}
	}
	
	// Time Complexity : O(N); Space Complexity : O(N)
	public static int findFibUsingTabulation(int n) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	// Time Complexity : O(N); Space Complexity : O(1)
	public static int  findFibUsingTabulationAndSpaceOptimization(int n) {
		int prev2 = 0, prev = 1, curr = 0;
		
		for(int i = 2; i <= n; i++) {
			curr = prev + prev2;
			prev2 = prev;
			prev = curr;
		}
		
		return curr;
	}
}
