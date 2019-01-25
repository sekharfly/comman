package basics.Programs;

public class PalindromeNumber {

	static int rem;
	static int sum = 0;
	static int temp;
	static int n = 453;

	public static void main(String[] args) {
		temp = n;
		while (n > 0) {
			rem = n % 10;
			sum = (sum * 10) + rem;
			n = n / 10;
		}
		if (temp == sum) {
			System.out.println("palindram");
		} else {
			System.out.println("not palindram");
		}
	}
}
