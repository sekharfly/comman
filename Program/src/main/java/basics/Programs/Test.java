package basics.Programs;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

class Test {

	public static void main(String[] args) {
		int[] a = { 1, 4, 7, 3, 8, 9, 3, 2, 0 };

		Arrays.asList(a);

		//System.out.println("binarySearch" + Arrays.binarySearch(a, 1));

		for (int i = a.length - 1; i >= 0; i--) {
			// System.out.println(a[i]);
		}

		int temp;

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j])

				{

					temp = a[i];

					a[i] = a[j];

					a[j] = temp;

				}
			}
		}

		// System.out.print(a[0] + ",");

		// System.out.print("Ascending Order:");

		for (int i = 0; i < a.length; i++)

		{

			// System.out.print(a[i] + ",");

		}

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("1");
		arrayList.add("15");
		arrayList.add("sekhar");
		arrayList.add("fly");

		
		arrayList.forEach(System.out::println);
		
		
		Collections.reverse(arrayList);

		String[] names = { "sekhar", "vinay", "karthik", "fly" };

		Arrays.sort(names);
		
		
		//System.out.println(Arrays.toString(names));
		
		for (int i = 0; i < names.length; i++) {
			for (int j = i + 1; j < names.length; j++) {
				if (names[i].compareTo(names[j]) > 0) {
					String tmp = names[i];
					names[i] = names[j];
					names[j] = tmp;
				}

			}

		}
		
		//System.out.println(Arrays.toString(names));
		
		
		System.out.println(DateFormat.getDateInstance(0,Locale.UK).format(new Date()));
		
		 ArrayList<Integer> arrL = new ArrayList<Integer>(); 
	        arrL.add(1); 
	        arrL.add(2); 
	        arrL.add(3); 
	        arrL.add(4); 
	  
	        // Using lambda expression to print all elements 
	        // of arrL 
	        arrL.forEach(n -> System.out.println(n)); 
	  
	        // Using lambda expression to print even elements 
	        // of arrL 
	      //  arrL.forEach(n -> { if (n%2 == 0) System.out.println(n); }); 
	    } 

		
		
	}

