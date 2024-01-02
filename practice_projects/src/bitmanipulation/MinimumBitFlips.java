// https://leetcode.com/problems/minimum-bit-flips-to-convert-number

package bitmanipulation;

public class MinimumBitFlips {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minBitFlips(10, 7));
		System.out.println(minBitFlips(3, 4));
	}

	public static int minBitFlips(int start, int goal){
        // Write your code here.
		int xor = start^goal;
		int count = 0;
		// Counting set bits of the binary number
		while(xor > 0) {
			xor = xor & xor - 1;
			
			count++;
		}
		return count;
    }
}
