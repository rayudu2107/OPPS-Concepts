package constructoroverloading;

public class Employee {
	String name;
	long phno;
	String degree;
	int exp;
	String email;
	Employee(String name,long phno,String degree,int exp,String email){
		this.name=name;
		this.phno=phno;
		this.degree=degree;
		this.exp=exp;
		this.email=email;
	}
	Employee(String name,long phno,String degree,String email){
		this.name=name;
		this.phno=phno;
		this.degree=degree;
		this.email=email;
	}
	void display() {
		System.out.println("Employee Name "+name+" Mobile number "+phno+ " Qualification is "+degree+ "email "+email+" Expericences "+exp);
	}
	public static void main(String[] args) {
		Employee e1=new Employee("suraj",9638527410L,"MBA",2,"Suraj@gamil.com");
		Employee e2=new Employee("manoj",1478529630,"MSC","manoj@gmail.com");
		e1.display();
		System.out.println("===============================================================================================");
		e2.display();
	}
}
