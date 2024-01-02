package recursion;

public class PrintAscendingOrderUsingBacktracking {
	
	public static void print(int n) {
		if(n == 0) return;
		print(n - 1);
		System.out.println(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(10);
	}

}
