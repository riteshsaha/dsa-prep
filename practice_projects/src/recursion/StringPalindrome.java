package recursion;

public class StringPalindrome {
	
	static String str = "MADAM";
	
	// Using two pointers
	public static boolean palindrome(int left, int right) {
		if(left >= right) return true;
		if(str.charAt(left) != str.charAt(right)) return false;
		return palindrome(left + 1, right - 1);
	}

	// Using one pointer
	public static boolean palindrome(int i) {
		int n = str.length() - 1;
		if(i >= n/2) return true;
		if(str.charAt(i) != str.charAt(n-i)) return false;
		return palindrome(i+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Using two pointer
		System.out.println(palindrome(0, str.length() - 1));
		//Using one pointer
		System.out.println(palindrome(0));
	}

}
