package recursion;

public class PrintAscendingOrder {
	
	public static void print(int i, int n) {
		if(i > n) return;
		System.out.println(i);
		print(i + 1, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(1, 10);
	}

}
