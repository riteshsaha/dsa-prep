package recursion;

public class Fibonacci {
		
	// Using two pointers
	public static int fibonacci(int n) {
		if(n <= 1) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(4));
	}

}
