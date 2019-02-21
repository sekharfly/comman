package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListToMap {

	static int key = 1;

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("sekhar");
		arrayList.add("aekhar2");
		arrayList.add("zekhar3");

		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		for (String list : arrayList) {
			hashMap.put(key++, list);
		}
		System.out.println(hashMap);

		List<String> listss = new ArrayList<String>();
		listss.addAll(hashMap.values());
		System.out.println(listss);

	}
}
