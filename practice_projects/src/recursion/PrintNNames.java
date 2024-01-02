package recursion;

public class PrintNNames {
	
	public static void print(int n) {
		if(n == 0) return;
		System.out.println("Ritesh " + n);
		print(n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(10);
	}

}
