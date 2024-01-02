// https://leetcode.com/problems/longest-common-prefix/

package strings;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs);
		
		String firstElement = strs[0];
		String lastElement = strs[strs.length - 1];
		int index = 0;
		while(index < firstElement.length() && index < lastElement.length()) {
			if(firstElement.charAt(index) == lastElement.charAt(index)) {
				index++;
			} else {
				break;
			}
		}
		return firstElement.substring(0, index);
	}

}
