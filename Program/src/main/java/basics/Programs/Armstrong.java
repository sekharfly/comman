package basics.Programs;

public class Armstrong {

	public static void main(String[] args) {

		int am, temp;
		int n = 370;
		int c = 0;

		temp = n;
		for (int i = n; i > 0; i++) {

			am = n % 10;
			n = n / 10;
			c = c + (am * am * am);

		}
		if (temp == c)
			System.out.println("Armstorng");
		else
			System.out.println("not ");
	}

}
