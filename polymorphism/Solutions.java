package polymorphism;
class Employee{
	void work() {
		System.out.println("workig");
	}
}
class Developer extends Employee{
	void work() {
		System.out.println("developing App");
	}
}
class Tester extends Employee{
	void work() {
		System.out.println("testing APP ");
	}
}
public class Solutions {
public static void main(String[] args) {
	Employee e1=new Tester();
	e1.work();
	Employee e2=new Developer();
	e2.work();
	System.out.println("-------------------------");
	Employee emp;
	emp=new Developer();
	emp.work();
	emp=  new Tester();
	emp.work();
}
}