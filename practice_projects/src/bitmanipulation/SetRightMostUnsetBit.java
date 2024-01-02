// https://www.codingninjas.com/studio/problems/set-the-rightmost-unset-bit_8160456

package bitmanipulation;

public class SetRightMostUnsetBit {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(setBits(5));
		System.out.println(setBits(10));
		System.out.println(setBits(7));
	}

	public static int setBits(int N){
        // Write your code here.
		if((N & N+1) == 0) {
			return N;
		} 
		return N | N+1;
    }
}
