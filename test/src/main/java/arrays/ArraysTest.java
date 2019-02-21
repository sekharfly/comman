package arrays;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArraysTest {
	static int r = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte x = 10;
		short y = 10;
		int z = 10;
		long b = 10;
		char ch = 'a';
		String st  = "abc";
		
		float fl[] = {1,2,3};
		int a[] = {1,2,3};
		a = new int[30];
		a = new int[x];
		a = new int[y];
		//a = new int[b];  //not acceptable
		a = new int[ch];
		//a = new int[st];  //not acceptable
		
        a[0] = 10;
		
		System.out.println(a.length);  //Arrays
		System.out.println(st.length()); // String
		System.out.println(new int[]{10,20,30});
		
		sum(new int[] {10,20,30});
		
	}

	private static void sum(int[] is) {
		// TODO Auto-generated method stub
		int total = 0;
		System.out.println("r is"+r);
		for(int x : is) {
			
			total = total + x;
		}
		//System.out.println("sum : "+total);
		
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("sekhar");
		arrayList.add("aekhar2");
		arrayList.add("zekhar3");
		
		
		arrayList.stream().sorted((o1,o2)->o2.compareTo(o1)).forEach(System.out::println);
		
		arrayList.stream().sorted((a1,a2)->a2.compareTo(a1)).forEach(System.out::println);
		
		String fast = "someone,extremely,diligent,orskillful";
		
		StringTokenizer stringTokenizer = new StringTokenizer(fast);
		while (stringTokenizer.hasMoreTokens()) {
			stringTokenizer.nextToken(",");
			System.out.println(stringTokenizer.nextElement());
			     
		}
		
	}

}
