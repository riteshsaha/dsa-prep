// https://www.codingninjas.com/studio/problems/count-total-set-bits_784

package bitmanipulation;

public class CountSetBits {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSetBits(4));
		System.out.println(countSetBits(7));
		System.out.println(countSetBits(5));
	}

	public static int countSetBits(int n){
        // Write your code here.
		int setBitCount = 0;
		for(int i = 1; i <= n; i++) {
			setBitCount += count(i);
		}
		
		return setBitCount;
    }
	
	private static int count(int num) {
		int cnt = 0;
		while(num != 0) {
			num = num & num-1;
			cnt++;
		}
		return cnt;
	}
}
