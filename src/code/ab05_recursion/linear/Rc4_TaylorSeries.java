package code.ab05_recursion.linear;

public class Rc4_TaylorSeries {

	private static int p=1, f=1;
	public static int getTaylorSeries(int x, int n) {
		int r = 0;
		if (n==0)
			return 1;
		else {
			r = getTaylorSeries(x, n-1);
			p = p*x;
			f = f*n;
			return r + (p/f);
		}
		
	}
	// this has issues like global variables usage and integer division issue.
	
	// enhanced version
	public static double taylor(int x, int n) {
        return taylor(x, n, 1, 1); // call helper with p=1, f=1
    }

    private static double taylor(int x, int n, double p, double f) {
        if (n == 0)
            return 1;
        double r = taylor(x, n - 1, p, f);
        p = p * x;
        f = f * n;
        return r + (p / f);
    }
	
	public static void main(String[] args) {
		
	}
	
}