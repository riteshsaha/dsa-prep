// https://leetcode.com/problems/largest-odd-number-in-string/

package strings;

public class LargestOddNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "354278";
		System.out.println(largestOddNumber(num));
	}
	
	public static String largestOddNumber(String num) {
		for(int i = num.length() - 1; i >= 0; i--) {
			if(num.charAt(i) % 2 != 0) {
				return num.substring(0, i + 1);
			}
		}
		return "";
	}

}
