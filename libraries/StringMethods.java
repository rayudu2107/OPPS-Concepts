package libraries;

public class StringMethods {
public static void main(String[] args) {
	System.out.println("================String methods==============");
	String s="Software Engineer";
	System.out.println(s.length());
	System.out.println(s.toUpperCase());
	System.out.println(s.toLowerCase());
	System.out.println(s.startsWith("soft"));
	System.out.println(s.endsWith("neer"));
	System.out.println(s.charAt(4));
	System.out.println(s.contains("ware"));
	String x="java",y="html",z="java";
    System.out.println(s.compareToIgnoreCase(s));
    System.out.println(s.substring(4));
    System.out.println(s.substring(0, 4));
	System.out.println(x.equals(z));//String class to equals method is overridden
	System.out.println(s);          //String class to toString method is overridden
	System.out.println(y.hashCode());//String class to hashCode method is overridden
}
}
