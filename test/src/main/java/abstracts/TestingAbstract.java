package abstracts;

abstract class Main {

	abstract void m1();

	void m2() {
		System.out.println("testing");
	}
}

class subAbst extends Main {

	@Override
	void m1() {
		// TODO Auto-generated method stub

	}


}

public class TestingAbstract {
	public static void main(String[] args) {

		subAbst subAbst = new subAbst();
		subAbst.m2();
	}
}