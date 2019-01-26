package com.NesteToFlatArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sekharv
 *
 */
public class IntegerArrayFlattener {
	public static Integer[] flatten(Object[] inputArray) throws IllegalArgumentException {

		if (inputArray == null)
			return null;

		List<Integer> flatList = new ArrayList<Integer>();

		for (Object element : inputArray) {
			if (element instanceof Integer) {
				flatList.add((Integer) element);
			} else if (element instanceof Object[]) {
				flatList.addAll(Arrays.asList(flatten((Object[]) element)));
			} else {
				throw new IllegalArgumentException("Input must be an array of Integers or nested arrays of Integers");
			}
		}
		return flatList.toArray(new Integer[flatList.size()]);
	}

	public static void main(String[] args) {
		Integer[] flatten = flatten(new Object[] { 1, 2, new Object[] { 3 }, 4 });
		for (Integer x : flatten) {
			System.out.println(x);

		}
	}
}
