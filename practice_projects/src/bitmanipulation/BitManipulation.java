// https://www.codingninjas.com/studio/problems/bit-manipulation_8142533

package bitmanipulation;

public class BitManipulation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] resultArr = bitManipulation(25, 3);
		for(int i = 0; i < resultArr.length; i++) {
			System.out.println(resultArr[i] + " ");
		}
		
		System.out.println("----------------------");
		int[] resultArr1 = bitManipulation(9, 3);
		for(int i = 0; i < resultArr1.length; i++) {
			System.out.println(resultArr1[i] + " ");
		}
		
		System.out.println("----------------------");
		int[] resultArr2 = bitManipulation(11, 2);
		for(int i = 0; i < resultArr2.length; i++) {
			System.out.println(resultArr2[i] + " ");
		}
		
		System.out.println("----------------------");
	}

	public static int[] bitManipulation(int num, int i){
        // Write your code here.
		int[] result = new int[3];
		
		result[0] = getBitValueAtPosition(num, i);
		result[1] = setBitValueAtPosition(num, i);
		result[2] = clearBitValueAtPosition(num, i);
		
		return result;
    }
	
	public static int getBitValueAtPosition(int num, int i) {
		return ((1 << i-1) & num) >> i-1;
	}
	 
	public static int setBitValueAtPosition(int num, int i) {
		return (1 << i-1) | num;
	}
	
	public static int clearBitValueAtPosition(int num, int i) {
		return (~(1 << i-1)) & num;
	}
}
