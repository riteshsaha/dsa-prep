// https://leetcode.com/problems/divide-two-integers/

/*
 * Need to understand the flow : 
 * https://leetcode.com/problems/divide-two-integers/solutions/1929540/java-solution-with-explanation/
 */


package bitmanipulation;

public class DivideTwoIntegersUsingBitOperation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(15, 3));
		System.out.println(divide(10, 3));
		System.out.println(divide(7, -3));
	}

	public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int r = 0;
        while(dividend - divisor >= 0){
            int count = 0;

            while(dividend - (divisor << 1 << count) >= 0){
                count++;
            }
            r += 1 << count;
            dividend -= divisor << count;
        }

        if(neg){
            r = ~r + 1;
        }
        return r;
    }
}
