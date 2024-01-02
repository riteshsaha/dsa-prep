// https://leetcode.com/problems/longest-palindromic-substring/

package strings;

public class LongestPalindromeString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindromeUsingManachersAlgo("babad"));
		System.out.println(longestPalindrome("cbbd"));
	}
	
	 public static String longestPalindrome(String s) {
		 String result = "";
		 int maxLength = 0;
		 
		 if(s.length() <= 1) {
			 return result;
		 }
		 
		 for(int i = 1; i < s.length(); i++) {
			 for(int j = i; j <= s.length(); j++) {
				 String subString = s.substring(i, j);
				 if(isPalindrome(subString) && subString.length() > maxLength) {
					 result = subString;
					 maxLength = result.length();
				 } 
			 }
		 }
		 return result;
	}
	 
	private static boolean isPalindrome(String str) {
		StringBuilder revStr = new StringBuilder();
		for(int i = str.length() - 1; i >= 0; i--) {
			revStr.append(str.charAt(i));
		}
		if(str.equals(revStr.toString())) {
			return true;
		}
		return false;
	}
	
	public static String longestPalindromeUsingManachersAlgo(String s) {
        if (s == null || s.length() < 1) return "";

        // Transform the input string to include special characters
        StringBuilder modifiedS = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            modifiedS.append(c).append("#");
        }

        int n = modifiedS.length();
        int[] P = new int[n]; // Array to store the length of palindromes at each position
        int C = 0; // Center of the current palindrome
        int R = 0; // Right boundary of the current palindrome

        int maxLen = 0; // Maximum length of a palindrome found
        int maxCenter = 0; // Center of the palindrome with maximum length

        for (int i = 0; i < n; i++) {
            if (i < R) {
                int mirror = 2 * C - i; // Mirror position of i
                P[i] = Math.min(R - i, P[mirror]);
            }

            // Expand around the current character
            int a = i + (1 + P[i]);
            int b = i - (1 + P[i]);
            while (a < n && b >= 0 && modifiedS.charAt(a) == modifiedS.charAt(b)) {
                P[i]++;
                a++;
                b--;
            }

            // Update the center and right boundary if needed
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

            // Update the maximum length and its center
            if (P[i] > maxLen) {
                maxLen = P[i];
                maxCenter = i;
            }
        }

        int start = (maxCenter - maxLen) / 2; // Start index of the longest palindrome
        int end = start + maxLen; // End index of the longest palindrome

        return s.substring(start, end);
    }
	
}

