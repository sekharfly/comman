package strings;

import java.util.ArrayList;
import java.util.Comparator;

public class StringExp {

	String name;
	int age;

	public StringExp(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	void m1() {
		System.out.println("ma");
	}

	void m2() {
		System.out.println("m2");
	}

	void m3() {
		System.out.println("m3");
	}

	public static void main(String[] args) {

		StringExp ob1 = new StringExp("namn", 10);
		StringExp ob2 = new StringExp("sek", 10);
		StringExp ob3 = new StringExp("namn", 10);

		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));
		System.out.println(ob1 == ob3);

		String n1 = new String("sekhar");
		String n2 = new String("sekhar");
		System.out.println(n1.equals(n2));
		System.out.println(n1 == n2);

		StringBuffer sb = new StringBuffer("dsfhkdhkj");
		System.out.println(sb.reverse());
		
		
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("sekhar");
		arrayList.add("aekhar2");
		arrayList.add("zekhar3");
		//arrayList.stream().sorted().forEach(System.out::println);
		System.out.println("===");
//		arrayList.sort(new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
		//arrayList.stream().sorted().forEach(System.out::println);
		arrayList.stream().sorted((o1,o2)->o2.compareTo(o1)).forEach(System.out::println);
	
	}

}
