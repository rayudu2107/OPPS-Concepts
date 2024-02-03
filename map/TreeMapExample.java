package map;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
//		TreeMap<Integer, String> map = new TreeMap<>();
//		map.put(40, "haresh");
//		map.put(30, "pradeep");
//		map.put(20, "giiii");
//		map.put(10, "anil");
//		Set<Integer> keySet = map.keySet();
//		for (int i : keySet) {
//			System.out.println(i + "----> " + map.get(i));
//		}
		System.out.println("-------------------------");
		TreeMap<String, String>map=new TreeMap();
		map.put("EFCODE", "haresh");
		map.put("GOOGLE", "pradeep");
		map.put("TREE", "giiii");
		map.put("DOLO", "anil");
		Set<String>keys=map.keySet();
for(String i:keys) {
	System.out.println(i + "----> " + map.get(i));
}
	}
}
