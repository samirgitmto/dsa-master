package code.ab05_recursion.linear;

public class Rc1 {

	public static void f1(int n) {
		if (n>0) {
			System.out.print(n);
			f1(n-1);
		}
		else
			System.out.println();
	}
	public static void f2(int n) {
		if (n>0) {
			f2(n-1);          // going to depth first
			System.err.print(n);
		}
		else
			System.out.println();
	}
	
	// time complexity: O(n) - linear time complexity
	// space complexity: O(n) - linear space complexity due to recursion stack
	public static int getFactorial(int n) {
		if (n<=1)
			return 1;
		
		return n * getFactorial(n-1);
	}
	
	
	// time complexity: O(2^n) - exponential time complexity due to repeated calculations
	// space complexity: O(n) - linear space complexity due to recursion stack depth
	public static int getFibonacci(int n) {
		if (n==1)
			return 1;
		else if (n<=0)
			return 0;
		
		return getFibonacci(n-1) + getFibonacci(n-2);
	}
	
	public static void main(String[] args) {
		f1(4);
		f2(4);
		System.out.println("\n" + getFactorial(4));
		System.out.println(getFibonacci(4));
//		System.out.println(getFibonacci(8));
	}
	
}