// https://leetcode.com/problems/rotate-string/

package strings;

public class RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rotateString("abcde", "cdeab"));
		System.out.println(rotateString("foo", "bar"));
	}
	
	public static boolean rotateString(String s, String goal) {
	    if(s.length() != goal.length()) {
	    	return false;
	    }
	    
	    if((s + s).contains(goal)) {
	    	return true;
	    }
	    return false;
	}
}
