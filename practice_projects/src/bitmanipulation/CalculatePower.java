// https://leetcode.com/problems/powx-n/

package bitmanipulation;

public class CalculatePower {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(2.00000, 10));
		System.out.println(myPow(2.10000, 3));
		System.out.println(myPow(2.00000, -2));
	}

	public static double myPow(double x, int n) {
        // Write your code here.
		double myPow = 1;
		
		if(n < 0) {
			n = -n;
			x = 1/x;
		}
		
		while(n != 0) {
			if((n & 1) != 0) {	// Check if n is odd or even
				myPow *= x;
			}
			
			x *= x;
			// Logical Right Shift(>>>) means the bits are right shifted but the right most set bit isn't copied at the start
			// It is different from Arithmetic Right Shift(>>) where right most set bits are copied to start on being shifted out
			n = n >>> 1;
		}
		
		return myPow;
    }
}
