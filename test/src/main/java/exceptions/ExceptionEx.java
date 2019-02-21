package exceptions;

public class ExceptionEx extends Exception {

	ExceptionEx(String s){
		super(s);
	}

	void userNotfound() throws UserNotFound {
		//throw new UserNotFound("User not fount");
		//throw new ArithmeticException("/zero");
	}

	public static void main(String[] args) {

		ExceptionEx exceptionEx = new ExceptionEx("");
		

	}

}
