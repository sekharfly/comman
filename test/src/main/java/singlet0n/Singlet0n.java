package singlet0n;

public class Singlet0n {

	public static Singlet0n th;
	
	private Singlet0n() {
		
	}

	public static Singlet0n getInstance() {
		if(th==null) {
			th = new Singlet0n();
		}
		return th;
	}
	public static void main(String[] args) {
		Singlet0n singlet0n = new Singlet0n();
		Singlet0n singlet0n2 = new Singlet0n();
		
	}

}
