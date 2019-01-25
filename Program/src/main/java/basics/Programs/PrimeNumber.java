package basics.Programs;

public class PrimeNumber {

	public static void main(String[] args) {

		int temp = 0;
		boolean isPrime = true;
		int num = 19;

		for (int i = 2; i < num / 2; i++) {
			temp = num % i;
			if (temp == 0) {
				isPrime = false;
				break;
			}

		}
		if (isPrime) {
			System.out.println("prime");
		} else {
			System.out.println("not");
		}
	}

}
