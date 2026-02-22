package code.ab05_recursion.linear;

public class Rc6_Combination {

	// nCr
	public static int combinations(int n, int r) {
		if (r==0 || n==r) {
			return 1;
		}
		return combinations(n-1, r-1) + combinations(n-1, r);
	}
	
	public static void main(String[] args) {
		System.out.println(combinations(4, 2));
		System.out.println(combinations(5, 2));   //5!/3!*2! = 10
	}
	
}