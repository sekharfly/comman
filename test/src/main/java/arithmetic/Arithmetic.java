package arithmetic;

public class Arithmetic {

	public static void main(String[] args) {

		int a = 10, b = 5;
		System.out.println(a + "----" + b);

		a = a + b; // 15
		b = a - b; // 5
		a = a - b; // 10

		System.out.println(a + "----" + b);
	}
}
