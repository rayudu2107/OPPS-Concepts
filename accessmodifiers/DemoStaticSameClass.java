package accessmodifiers;

//Static members present in different class access className.memberName.
public class DemoStaticSameClass {
	static int v1 = 100;
	int v2 = 100;

	public static void test() {
		System.out.println("this is test() of DemoStaticSameClass class");
	}

	public static void main(String[] args) {
		System.out.println("V1 is =" + v1);
//      A Non static variable can not be referenced by a static context.		
//		System.out.println("V2 is =" + v2);
		test();
	}
}
