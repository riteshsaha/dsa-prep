// https://leetcode.com/problems/remove-outermost-parentheses/

package strings;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the  sky is blue";
		System.out.println(reverseWordsUsingTwoPointer(s));
	}
	
	public static String reverseWords(String s) {
		String[] temp = s.trim().split("\\s+");
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < temp.length; i++) {
			sb.append(temp[temp.length - 1 - i]).append(" ");
		}
		return sb.toString();
	}
	
	public static String reverseWordsUsingTwoPointer(String s) {
		String[] arr = s.trim().split("\\s+");
		int i=0, j = arr.length - 1;
		
		while(i < j) {
			String temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return String.join(" ", arr);
	}

}
