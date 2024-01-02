// https://leetcode.com/problems/roman-to-integer/

package strings;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToIntBruteForce("LVIII"));
		System.out.println(romanToIntOptimal("MCMXCIV"));
	}
	
	/*
	 * Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		
		I can be placed before V (5) and X (10) to make 4 and 9. 
		X can be placed before L (50) and C (100) to make 40 and 90. 
		C can be placed before D (500) and M (1000) to make 400 and 900.
	 */
	public static int romanToIntBruteForce(String s){
	    int finalNum = 0;
	    
	    for(int i = 0; i < s.length(); i++) {
	    	char ch = s.charAt(i);
	    	char nextChar = (i < s.length() - 1) ? s.charAt(i+1) : Character.MIN_VALUE;
	    	switch(ch) {
	    		case 'I':
	    			if(nextChar == 'V') {
	    				finalNum = finalNum + 4;
	    				i++;
	    			} else if(nextChar == 'X') {
	    				finalNum = finalNum + 9;
	    				i++;
	    			} else {
	    				finalNum = finalNum + 1;
	    			}
	    			break;
	    		case 'V':
	    			finalNum = finalNum + 5;
	    			break;
	    		case 'X':
	    			if(nextChar == 'L') {
	    				finalNum = finalNum + 40;
	    				i++;
	    			} else if(nextChar == 'C') {
	    				finalNum = finalNum + 90;
	    				i++;
	    			} else {
	    				finalNum = finalNum + 10;
	    			}
	    			break;
	    		case 'L':
	    			finalNum = finalNum + 50;
	    			break;
	    		case 'C':
	    			if(nextChar == 'D') {
	    				finalNum = finalNum + 400;
	    				i++;
	    			} else if(nextChar == 'M') {
	    				finalNum = finalNum + 900;
	    				i++;
	    			} else {
	    				finalNum = finalNum + 100;
	    			}
	    			break;
	    		case 'D':
	    			finalNum = finalNum + 500;
	    			break;
	    		case 'M':
	    			finalNum = finalNum + 1000;
	    			break;
	    	}
	    	System.out.print(finalNum + " -> ");
	    }
	    return finalNum;
	}
	
	public static int romanToIntOptimal(String s){
		int finalNum = 0;
		int num = 0, prev = 0;
		
		for(int i = s.length() - 1; i >= 0; i--) {
			switch(s.charAt(i)) {
				case 'I':
					num = 1;
					break;
				case 'V':
					num = 5;
					break;
				case 'X':
					num = 10;
					break;
				case 'L':
					num = 50;
					break;
				case 'C':
					num = 100;
					break;
				case 'D':
					num = 500;
					break;
				case 'M':
					num = 1000;
					break;
			}
			
			if(num < prev) {
				finalNum -= num;
			} else {
				finalNum += num;
			}
			prev = num;
			System.out.print(finalNum + " -> ");
		}
		return finalNum;
	}
}
