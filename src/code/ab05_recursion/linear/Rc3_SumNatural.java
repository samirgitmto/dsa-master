package code.ab05_recursion.linear;

public class Rc3_SumNatural {

	public static int getSum(int n) {
		if (n>0) {
			return n + getSum(n-1);
		}
		return 0;
	}
	public static int getSumEnhan(int n) {
		return n*(n+1)/2;
	}
	
	public static int power(int base, int exponent) {
		if (exponent==0)
			return 1;
		
		return power(base, exponent-1)*base;
	}
	// it can be improved further as follows:
	public static int powerEnhn(int base, int exponent) {
		if (exponent==0) {
			return 1;
		}
		if (exponent%2==0) {
			return powerEnhn(base*base, exponent/2);
		}
		else {
			return base*powerEnhn(base*base, (exponent-1)/2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getSum(5));
		System.out.println(power(2, 4));
		System.out.println(powerEnhn(2, 4));
	}
	
}