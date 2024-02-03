package list;

import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		Vector l=new Vector();
		l.add("PRADEEP");
		l.add("KUMAR");
		l.add('M');
		l.add("PASS");
		l.add(23);
		l.add("AUS17234");
		System.out.println(l);
		System.out.println("====forword direction====");
		for(int i=0;i<l.size();i++) {
			System.out.println(l.get(i));
		}
		System.out.println("======reverse direction======");
		for(int i=l.size()-1;i>=0;i--) {
			System.out.println(l.get(i));
		}
	}
}
