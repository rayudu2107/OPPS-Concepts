package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetImplClass {
public static void main(String[] args) {
	HashSet hs=new HashSet();
	hs.add("Wel Come To");
	hs.add("Java");
	hs.add(10);
	hs.add(10.75);
	hs.add('M');
	System.out.println("====HashSet===========");
	System.out.println(hs);
	LinkedHashSet l=new LinkedHashSet<>();
	l.add("Wel Come To");
	l.add("Java");
	l.add(10);
	l.add(10.75);
	l.add('M');
	System.out.println("=====LinkedHashSet=========");
	System.out.println(l);
	TreeSet<String> t=new TreeSet();
	t.add("Java");
	t.add("Ai");
	t.add("Reactjs");
	t.add("Jdbc");
	System.out.println("=====TreeSet============");
	System.out.println(t);
}
}

