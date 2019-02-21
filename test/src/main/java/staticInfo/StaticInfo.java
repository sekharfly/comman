package staticInfo;

public class StaticInfo {
	StaticInfo() {
		System.out.println("constractor");
	}

	static String str = "static variable";

	static {
		System.out.println("static block");
	}

	static void ma() {
		System.out.println("static method");
	}

	void maq() {
		System.out.println("instance method method");
	}

	public static void main(String[] args) {

		StaticInfo exceptionEx = new StaticInfo();
		ma();
		exceptionEx.maq();
		System.out.println(str);

	}
}
