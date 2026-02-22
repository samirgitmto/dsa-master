package code.ab05_recursion.tree;

public class Rc1_TreeRecursion {

	public static void f1(int n) {
		if (n>0) {
			System.out.print(n);
			f1(n-1);
			f1(n-1);
		}
		else
			System.out.println();
	}
	public static void main(String[] args) {
		f1(3);		/// 321 1 21 1
	}
}