package basics.Programs;

public class PrimeNumbers {

	public static void main(String[] args) {

		int i = 0;
		int num = 0;

		String prime = "";

		int n = 100;

		for (i = 1; i < n; i++) {
			int count = 0;
			for (num = i; num >= 1; num--) {

				if (i % num == 0) {
					count = count + 1;
				}
			}
			if (count == 2) {
				prime = prime + i + "  ";
			}

		}
		System.out.println("sdrfsd");
		System.out.println(prime);
	}

}
