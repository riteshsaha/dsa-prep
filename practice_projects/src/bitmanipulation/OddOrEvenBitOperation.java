// https://www.codingninjas.com/studio/problems/odd-even_7993579

package bitmanipulation;

public class OddOrEvenBitOperation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oddEven(5));
		System.out.println(oddEven(3));
		System.out.println(oddEven(128));
	}

	public static String oddEven(int N){
        // Write your code here.
		if((N & 1) != 0) {
			return "odd";
		} else {
			return "even";
		}
    }
}
