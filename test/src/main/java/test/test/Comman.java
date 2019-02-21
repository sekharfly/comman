package test.test;

public class Comman {

	public static void main(String[] args) {

		int tmp, reverse = 0, am;
		int n = 154;
		tmp = n;
		for (int i = n; i > 0; i++) {
			am = n % 10;
			n = n / 10;
			reverse = reverse + (am * am * am);

		}
		if(tmp == reverse) {
			System.out.println("arm");
		}else
		System.out.println("not");
	}

}
