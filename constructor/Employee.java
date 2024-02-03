package constructor;

public class Employee {
	String name;
	String id;
	double salary;
	String company_name;
	long phno;
	Employee(String name,String id,double salary,String company_name,long phno){
		this.name=name;
		this.id=id;
		this.salary=salary;
		this.company_name=company_name;
		this.phno=phno;	
	}
	void display() {
		System.out.println(name);
		System.out.println(id);
		System.out.println(salary);
		System.out.println(company_name);
		System.out.println(phno);
	}
	public static void main(String[] args) {
		Employee e1=new Employee("PRADEEP","CS200040",25000,"VSKUB",6360136630l);
		Employee e2=new Employee("RAJESH","CS200041",23455,"KLU",709551005l);
		e2.display();
		System.out.println("---------------------------------------------------------------");
		e1.display();
	}
}
