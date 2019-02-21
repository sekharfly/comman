package basics.Programs;

public class Armstrong {

	public static void main(String[] args) {
		int n = 153;
		int arm, c = 0;
		int temp = n;
		while (n > 0) {
			arm = n % 10;
			n = n / 10;
			c = c + (arm * arm * arm);
		}
		if (temp == c) {
			System.out.println("arm");
		} else {
			System.out.println("not arm");
		}
	}
}
