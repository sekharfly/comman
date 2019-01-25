package test.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	static int minMovies(List<Integer> avg) {

		int count = 0;
		for (int i = 0; i < avg.size(); i++) {
			if (i > 0) {
				if (avg.get(i) == 1 && avg.get(i - 1) != avg.get(i)) {
					Integer pre = avg.get(i - 1);
					Integer pres = avg.get(i);
					avg.remove(i - 1);
					avg.add(i, pre);
					avg.add(i - 1, pres);
					avg.remove(i - 1);
					count++;
				}

			}
		}

		return count;
	}

	static void bubble_sort(Integer A[], int n) {
		int temp;
		int count = 0;
		for (int k = 0; k < n - 1; k++) {
			for (int i = 1; i < n - k; i++) {
				if (A[i] > A[i - 1]) {
					temp = A[i];
					A[i] = A[i - 1];
					A[i - 1] = temp;
					count++;
				}
			}
		}
		System.out.println(count + "--------");
	}

	public static void main(String[] args) {

		int a[] = { 1, 1, 1, 1, 0, 1, 0, 1 };
		int n = 8;
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(0);
		arrayList.add(1);
		arrayList.add(0);
		arrayList.add(1);
		// int minMovies = minMovies(arrayList);
		// System.out.println(minMovies);
        Integer[] arr = new Integer[arrayList.size()]; 
        arr = arrayList.toArray(arr);
        bubble_sort(arr, n);
        
	}
}