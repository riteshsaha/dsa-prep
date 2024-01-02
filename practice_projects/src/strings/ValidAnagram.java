// https://leetcode.com/problems/valid-anagram/

package strings;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("abcde", "cdeat"));
		System.out.println(isAnagram("anagram", "nagaram"));
	}
	
	public static boolean isAnagram(String s, String t) {
	    if(s.length() != t.length()) {
	    	return false;
	    }
	    
	    int[] charArray = new int[26];
	    for(int i = 0; i < s.length(); i++) {
	    	charArray[s.charAt(i) - 'a']++;
	    	charArray[t.charAt(i) - 'a']--;
	    }
	    
	    for(int value : charArray) {
	    	if(value != 0) {
	    		return false;
	    	}
	    }
	    return true;
	}
}
