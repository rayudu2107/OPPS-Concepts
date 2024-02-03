package accessmodifiers;

public class DemoNStaticSameClass {
	static int v1 = 100;
	int v2 = 100;

	public void test() {
		System.out.println("this is test() of DemoNStaticSameClass class");
	}

	public static void main(String[] args) {
		System.out.println("V1 is =" + v1);
	
		System.out.println("V2 is =" + new DemoNStaticSameClass().v2);
		new DemoNStaticSameClass().test();
	}
}
