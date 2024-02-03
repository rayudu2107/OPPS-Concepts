package libraries;

public class StringBufferBuilder {
public static void main(String[] args) {
	String s1=new String("java");
	System.out.println(s1);
	s1.concat(" program");
	System.out.println(s1);
	String s2=new String("JAVA");
	String s3=s2.concat(" PROGRAM");
	System.out.println(s3);
	System.out.println("===============String end============");
	StringBuffer sBuffer=new StringBuffer("GOOD");
	sBuffer.append(" MAERNING");
	System.out.println(sBuffer);
	System.out.println("===============StringBuffer=============");
	StringBuilder sBuilder =new StringBuilder("good");
	sBuilder.append(" night");
	System.out.println(sBuilder);
	System.out.println("================StringBuilder===============");
}
}
