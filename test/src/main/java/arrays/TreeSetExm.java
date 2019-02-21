package arrays;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExm {



	public static void main(String[] args) {
		TreeSet treeSet = new TreeSet(new MyComprator());
		treeSet.add("sd");
		treeSet.add("sf");
		treeSet.add("rd");
		treeSet.add("vd");
		treeSet.add("od");
		System.out.println(treeSet);
	}

}

class MyComprator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = (String)o1;
		String s2 = o2.toString();
		return -s2.compareTo(s1);
	}
	
}