package isarelation;

class Manager {
	public void work() {
		System.out.println("Manager assign wark");
	}
}

interface Developer {
	public void develop();
}

interface Tester {
	public void tester();
}

class Person extends Manager implements Developer, Tester {

	@Override
	public void tester() {
		System.out.println("Testing App");
	}

	@Override
	public void develop() {
		System.out.println("Developing App");
	}

	@Override
	public void work() {
		System.out.println("manager assign work teammats");
	}

}

public class MultipleInheritence {
	public static void main(String[] args) {
		Person p = new Person();
	    p.tester();
	    p.develop();
	    p.work();
	}
}
