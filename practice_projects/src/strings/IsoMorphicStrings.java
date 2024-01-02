// https://leetcode.com/problems/isomorphic-strings/

package strings;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("add", "egg"));
		System.out.println(isIsomorphic("foo", ""));
	}
	
	public static boolean isIsomorphic(String firstString, String secondString) {
        Map<Character, Integer> firstStringMap = new HashMap<>();
        Map<Character, Integer> secondStringMap = new HashMap<>();
        
        if(firstString.length() != secondString.length()) {
        	return false;
        }
        
        for(int i = 0; i < firstString.length(); i++) {
        	if(firstStringMap.put(firstString.charAt(i), i) != secondStringMap.put(secondString.charAt(i), i)) {
        		return false;
        	}
        }
        
        return true;
    }


}
