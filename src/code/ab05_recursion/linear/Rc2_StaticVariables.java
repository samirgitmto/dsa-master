package code.ab05_recursion.linear;

public class Rc2_StaticVariables {

	static int globalCounter = 0;
	static int globalCounter2 = 0;
	
	public static int f1(int n) {
		if (n>0) {
//			System.out.print(n);
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
	
	public static void main(String[] args) {
		System.out.println(f1(4));
		System.out.println(f2(4));
	}
	
}