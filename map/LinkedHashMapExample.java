package map;

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapExample {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(40, "haresh");
		map.put(30, "pradeep");
		map.put(20, "giiii");
		map.put(10, "anil");
		Set<Integer> keys = map.keySet();
		for (Integer i : keys) {
			System.out.println(i + "--->" + map.get(i));
		}
}
}
