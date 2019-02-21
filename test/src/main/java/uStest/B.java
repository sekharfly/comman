package uStest;

public class B {

	B() {
		System.out.println("constractor");
	}

	static {
		System.out.println("static block");
	}
	{
		System.out.println("instance block");
	}

}
