// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

package strings;

public class MaxParenthesisDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
		System.out.println(maxDepth("(1)+((2))+(((3)))"));
	}
	
	public static int maxDepth(String expression) {
	    int ans = 0;
	    int max = 0;
	    
	    for(Character ch : expression.toCharArray()) {
	    	if(ch == '(') {
	    		ans++;
	    		max = Math.max(ans, max);
	    	} else if(ch == ')') {
	    		ans--;
	    	}
	    }
	    return max;
	}
}
