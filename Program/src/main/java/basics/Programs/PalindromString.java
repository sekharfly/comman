package basics.Programs;

public class PalindromString {

	public static void main(String[] args) {

		String original = "madam";
		String reverse = "";
		for (int i = original.length() - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
		}
		if (reverse.equals(original)) {
			System.out.println("palindram");
		} else {
			System.out.println("not a palindram");
		}
	}

}
