package pattrans;

public class Pattrans {

	public static void main(String[] args) {

		int n = 6;

		for (int i = 1; i < n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print("* ");
			}
			System.out.println(" ");
		}
		System.out.println("------------------------------------- ");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println(" ");
		}
		System.out.println("------------------------------------- ");

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------------------------------- ");
	}
}
