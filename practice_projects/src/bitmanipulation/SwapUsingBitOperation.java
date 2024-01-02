// https://www.codingninjas.com/studio/problems/swap-two-numbers_1380853

package bitmanipulation;

public class SwapUsingBitOperation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		swapNumber(8, 5);
		swapNumber(1, 2);
		swapNumber(5, 6);
	}

	public static void swapNumber(int a, int b) {
        // Write your code here.
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println(a + " " + b);
    }
}
