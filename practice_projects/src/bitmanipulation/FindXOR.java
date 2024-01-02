// https://www.codingninjas.com/studio/problems/l-to-r-xor_8160412

package bitmanipulation;

public class FindXOR {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findXOR(1, 5));
		System.out.println(findXOR(3, 5));
		System.out.println(findXOR(1, 3));
	}
	
	public static int findXOR(int L, int R){
        // Write your code here.
		int xor = 0;
		for(int i = 1; i <= L - 1; i++) {
			xor ^= i;
		}
		for(int j = 1; j <= R; j++) {
			xor ^= j;
		}
		return xor;
    }
}
