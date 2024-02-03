package accessmodifiers;

class Run {
	static int v1 = 100;

	public static void test() {
		System.out.println("this is test() of run class");
	}

}

public class DemoStaticDiffClass {
	public static void main(String[] args) {
		// cannot directly access static members of one class from another class in this
		// manner.
//	System.out.println("V1 is =" + v1);		
//	test();

		System.out.println("V1 is =" + Run.v1);
		Run.test();
	}
}
