// https://www.codingninjas.com/studio/problems/count-with-k-different-characters_1214627

package strings;

import java.util.Arrays;

public class CountSubstringsWithKDistinctCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSubStrings("aacfssa", 3));
		System.out.println(countSubStrings("qffds", 4));
	}
	
	 public static int countSubStrings(String str, int k) {
		int result = 0;
		for(int i = 0; i < str.length(); i++) {
			boolean[] charFound = new boolean[26];
			Arrays.fill(charFound, false);
			int distinctChars = 0;
			for(int j = i; j < str.length(); j++) {
				if(charFound[str.charAt(j) - 'a'] == false) {
					distinctChars++;
				}
				charFound[str.charAt(j) - 'a'] = true;
				
				if(distinctChars == k) {
					result++;
				}
			}
		}
		return result;
	}
}