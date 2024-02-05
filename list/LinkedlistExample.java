package list;

import java.util.LinkedList;

public class LinkedlistExample {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(100);
		l.add(200);
		l.add(300.0);
		l.add("java");
		System.out.println(l);// [100, 200, 300.0, java]
		System.out.println("----list intrface methods----");
		System.out.println(l.indexOf(300.0));
		System.out.println(l.lastIndexOf(200));
		System.out.println(l.get(3));
		System.out.println(l);
		l.add(0, 50);
		System.out.println(l);
		l.set(3, 250);
		System.out.println(l);
		System.out.println("collection methods");
		LinkedList m = new LinkedList();
		m.add(300);
		System.out.println(m);
		System.out.println(m.contains(300));
		System.out.println(m.contains("Java"));
		System.out.println(m.containsAll(l));
		m.remove(0);
		System.out.println(l);
		System.out.println(m.isEmpty());
		m.removeAll(m);
		System.out.println(m);
		System.out.println(l.size());
		System.out.println(m.isEmpty());
	}
}
