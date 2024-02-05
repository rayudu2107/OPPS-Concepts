package list;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList l=new ArrayList();
		l.add(10);
		l.add(20.0);
		l.add(10);
		l.add("java");
		l.add(null);
	    System.out.println(l);	//[10.20.0,10,java,null]
	    System.out.println(l.get(2));//[20.0]
	    l.contains("Java");//false
	    l.add(1,20);             
	    System.out.println(l); //[10,20,20.0,10,java,null]
	    l.set(2,30);
	    System.out.println(l);//[10,20,30,10,java,null]
	    System.out.println(l.isEmpty());//false
	    l.remove(3);
	    System.out.println(l);//[10,20,30,null]
	    l.clear();
	    System.out.println(l.isEmpty());//true
	}
}
