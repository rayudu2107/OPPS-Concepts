package singletonclass;

class PrimeMinister {
	String name = "Mr.Modi";
	int age = 73;
	// Rule-1
	private PrimeMinister() {
		System.out.println("PM Elected");
	}
	@Override
	public String toString() {
		return name + " is " + age + " years old!";
	}
	// Rule-3
	static PrimeMinister pm;// pm=null;

	// Rule-2
	public static PrimeMinister getInstance() {
		if (pm == null) {
			pm = new PrimeMinister();
		}
		return pm; // return new PrimeMinister();
	}
}
/*
 * Note: It is always a good practice to have the helper method name as getInstace()
 */
public class Runner {
	public static void main(String[] args) {
		// Internally ->PrimeMinister pm=new PrimeMinister();
		PrimeMinister.getInstance();
		PrimeMinister pm = PrimeMinister.getInstance();

		System.out.println(pm);// toString method is Overridden

		System.out.println(pm.name + " is " + pm.age + " years old!");
	}
}
