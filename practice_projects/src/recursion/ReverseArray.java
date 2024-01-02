package recursion;

public class ReverseArray {
	
	static int[] a = {1, 4, 3, 2, 3};
	
	// Using two pointers
	public static void reverse(int left, int right) {
		if(left >= right) return;
		//swap(a[left], a[right])
		a[left] = a[left] + a[right];
		a[right] = a[left] - a[right];
		a[left] = a[left] - a[right];
		reverse(left + 1, right - 1);
	}

	// Using one pointer
	public static void reverse(int i) {
		int n = a.length - 1;
		if(i >= n/2) return;
		//swap(a[i], a[n-i])
		a[i] = a[i] + a[n-i];
		a[n-i] = a[i] - a[n-i];
		a[i] = a[i] - a[n-i];
		reverse(i+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Using two pointer
		reverse(0, a.length - 1);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println(); 
		//Using one pointer
		reverse(0);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}

}
