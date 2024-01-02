package recursion;

public class PrintSumOfNNumbers {
	
	//Parameterized Recursion
	public static void printSum(int i, int sum) {
		if(i < 1)  {
			System.out.println(sum);
			return;
		}
		printSum(i - 1, sum + i);
	}
	
	//Functional Recursion - When a recursive function returns on every call
	public static int printSum(int n) {
		if(n == 0)  {
			return 0;
		}
		return n + printSum(n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSum(10, 0);
		System.out.println(printSum(10));
	}

}
