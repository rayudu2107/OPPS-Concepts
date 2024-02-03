package map;

import java.util.Hashtable;
import java.util.Set;

public class HashTableExample {
	public static void main(String[] args) {
		Hashtable<Integer, String> map = new Hashtable();
		map.put(40, "haresh");
		map.put(30, "pradeep");
		map.put(20, "giiii");
		map.put(10, "anil");
		Set<Integer> keys = map.keySet();
		for (int i : keys) {
			System.out.println(i + "----> " + map.get(i));
		}
	}
}
