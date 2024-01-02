// https://leetcode.com/problems/power-of-two

package bitmanipulation;

public class PowerOfTwo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(1));
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(3));
	}

	public static boolean isPowerOfTwo(int n){
        // Write your code here.
		if( n > 0 && (n & n-1) == 0) {
			return true;
		} else {
			return false;
		}
    }
}
