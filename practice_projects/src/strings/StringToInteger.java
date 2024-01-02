// https://leetcode.com/problems/string-to-integer-atoi/

package strings;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("           -42"));
		System.out.println(myAtoi("4193 with words"));
	}
	
	public static int myAtoi(String s) {
		s = s.trim();
		if(s.isEmpty()) {
			return 0;
		}
		
		int result = 0, index = 0;
		boolean isNegative = false;
		
		if(s.charAt(index) == '-') {
			isNegative = true;
			index++;
		} else if(s.charAt(index) == '+') {
			index++;
		}
		
		for(int i = index; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				int digit = s.charAt(i) - '0';
				
				if(result > Integer.MAX_VALUE || (result == Integer.MAX_VALUE && digit > Integer.MAX_VALUE % 10)){
					return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				result = result * 10 + digit;
			}
		}
		return isNegative ? -result : result;
	}
}
