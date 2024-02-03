package isarelation;
class Super1{
	int x=100;
}
class Child extends Super1{
	int y=200;
	public void test() {
		System.out.println("This is Super class "+x);
		System.out.println("This is child class "+y);
	}
}
public class SingleInheritance {
public static void main(String[] args) {
    Child c=new Child();
    c.test();
}
}
