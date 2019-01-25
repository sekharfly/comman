package basics.Programs;

public class Fibonacci {

	public static void main(String[] args) {

		int one = 0, two = 1, three = 1;

		int n = 10;
        System.out.println(one);
		for (int i = 1; i < n; i++) {
			one = two;
			System.out.println(one);
			two = three;
			three = one + two;
			
		}
	}

}
