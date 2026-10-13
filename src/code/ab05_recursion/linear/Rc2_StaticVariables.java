package code.ab05_recursion.linear;

public class Rc2_StaticVariables {

	static int globalCounter = 0;
	static int globalCounter2 = 0;
	
	int instanceCounter = 0;
	
	// returns 16 for n=4 instead of 10. see the result 10 in next method
	public static int f1(int n) {
		if (n>0) {
			System.err.println(n + " - " + globalCounter);
			globalCounter++;
			return f1(n-1) + globalCounter;
		}
		return 0;
	}
	public static int f2(int n) {
		if (n>0) {
			globalCounter2++;
			return globalCounter2 + f2(n-1);
		}
		return 0;
	}
	
//	even this also returns the same result 16 for n=4 due to the recursion order.
	int f1Instance(int n) {
		if (n>0) {
			System.err.println(n + " - " + instanceCounter);
			instanceCounter++;
			return f1Instance(n-1) + instanceCounter;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(f1(4));
		System.out.println(f2(4));
		
		Rc2_StaticVariables variables = new Rc2_StaticVariables();
		System.out.println(variables.f1Instance(4));
	}
	
}