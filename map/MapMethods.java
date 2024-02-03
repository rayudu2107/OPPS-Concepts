package map;

import java.util.HashMap;
import java.util.Set;

public class MapMethods {
public static void main(String[] args) {
	HashMap<Integer,String> map = new HashMap();
//	map.put(20, "Pradeep");
//	map.put("Hello", 10);
//	map.put(10, 20.5);
//	map.put("sql", "Jdbc");
	map.put(40, "Hello");
	map.put(10,"zzgood");
	map.put(20,"night");
//	System.out.println(map); // {20=Pradeep, Hello=10, 10=20.5, sql=Jdbc}
//	System.out.println(map.get(10));// 20.5
//	System.out.println(map.containsKey(10));// true
//	System.out.println(map.containsValue("pradeep"));// false
//	System.out.println(map.size());// 4
//	map.remove(10);
//	System.out.println(map);// {20=Pradeep, Hello=10, sql=Jdbc}
//	System.out.println(map.isEmpty());// false
//	System.out.println(map.keySet());// [20, Hello, sql]
//	map.clear();
//	System.out.println(map.isEmpty());// true
//	System.out.println(map);// {}
	Set<Integer>keys=map.keySet();
	for(Integer key:keys) {
		System.out.println(key+"->"+map.get(key));
	}
}
}

