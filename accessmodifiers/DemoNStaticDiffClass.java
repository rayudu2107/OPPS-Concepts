package accessmodifiers;

//non static members present in different class  access creating object.memberName.
class Bike{
	int v2 = 1000;

	public void test() {
		System.out.println("this is test() of bike class");
	}
}
public class DemoNStaticDiffClass {
	public static void main(String[] args) {
		System.out.println("V2 is =" + new Bike().v2);
		new Bike().test();
	}
}
