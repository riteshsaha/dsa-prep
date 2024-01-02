// https://leetcode.com/problems/remove-outermost-parentheses/

package strings;

public class RemoveOuterMostParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(()())(())";
		System.out.println(removeOuterParentheses(s));
	}
	
	public static String removeOuterParentheses(String s) {
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		
		for(char c : s.toCharArray()) {
			if(c == '(') {
				if(cnt > 0) {
					sb.append(c);
				}
				cnt++;
			} else {
				cnt--;
				if(cnt > 0) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

}
