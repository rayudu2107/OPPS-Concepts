package typecsating;

public class NarrowWideningCasting {
	public static void main(String[] args) {
		System.out.println("......WIDELEING............");
		int x=20;
		double y=x;
		System.out.println(x+ " "+y);
		char i='A';
		int j=i;
		System.out.println(i+"  "+j);
		double a=24346;
		System.err.println(a);
		System.out.println((int)'a');
		System.err.println((char)98);
		System.out.println("----------NAROWWING-------------");
		int p=97;
		char q=(char)p;
		System.out.println(p+" "+q);
		double k=234.45;
		int l=(int)k;
		System.out.println(k+" "+l);
		System.out.println((int)454.43);
		System.out.println((byte)22.9);
		System.out.println("A"+20);
		
	}
}
