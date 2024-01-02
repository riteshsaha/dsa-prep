package recursion;

public class PrintDescendingOrderUsingBacktracking {
	
	public static void print(int i, int n) {
		if(i > n) return;
		print(i + 1, n);
		System.out.println(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(1, 10);
	}

}
