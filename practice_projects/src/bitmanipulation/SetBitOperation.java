// https://www.codingninjas.com/studio/problems/check-whether-k-th-bit-is-set-or-not_5026446

package bitmanipulation;

public class SetBitOperation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isKthBitSet(5, 1));
		System.out.println(isKthBitSet(3, 2));
		System.out.println(isKthBitSet(128, 7));
	}

	public static boolean isKthBitSet(int n, int k){
        // Write your code here.
		if(((1 << k-1) & n) != 0) {
			return true;
		} else {
			return false;
		}
    }
}
