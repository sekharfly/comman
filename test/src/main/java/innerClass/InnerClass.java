package innerClass;

public class InnerClass {
	
	class innn{
		private void inner() {
			System.out.println("inner");

		}
	}
	
	void mathodInner() {
		class metINN{
			private void inners() {
				System.out.println("inner");

			}
		}
		
		metINN metINN = new metINN();
		metINN.inners();
	}
	
	
	public static void main(String[] args) {
		
		InnerClass innerClass = new InnerClass();
		InnerClass.innn trdt = innerClass.new innn();
		trdt.inner();
		innerClass.mathodInner();
		
	}

}
