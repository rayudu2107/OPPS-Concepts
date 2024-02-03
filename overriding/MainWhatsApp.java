package overriding;

class w1{
	void report() {
		System.out.println("single tick");
	}
}
class w2 extends w1{
	void report() {
//		super.report();
		System.out.println("double tick");
	}
}
class wa3 extends w2{
	void report() {
		super.report();//super keyword used  within the subclass methods in order to access properties of it's immediate super class
		System.out.println("blue tick");
	}
}
public class MainWhatsApp {
public static void main(String[] args) {
	wa3 a=new wa3();
	a.report();
}
}

