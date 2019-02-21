
@FunctionalInterface
interface Cal {
	int calculate(int x);
	default void calculatei(int x) {
		System.out.println("default");
	}
	static void calculateid(int x) {
		System.out.println("static");
	}
}

public class FunctionInterface {

	public static void main(String[] args) {
		int n= 5;
		Cal cl= (int x)->x*x;
		int rs = cl.calculate(n);
		System.out.println(rs);
		Cal.calculateid(4);
	}

}
