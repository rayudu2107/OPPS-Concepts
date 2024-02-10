package comparable;

import java.util.TreeSet;

class Employee implements Comparable<Employee>{
	String name;
	Double salary;
	String role;
	public Employee(String name,String role,Double salary) {
		this.name=name;
		this.role=role;
		this.salary=salary;
	}
	public String toString() {
		return "Name: "+name+" Role: "+role+" Salary :"+salary;
	}
	@Override
	public int compareTo(Employee e) {
	return this.name.compareTo(e.name);
	
//		return this.role.compareTo(e.role);
	}
}
public class SortEmployee {
public static void main(String[] args) {
	Employee e1=new Employee("Anil","Electrician",29999.0);
	Employee e2=new Employee("Redddy","Filtter",45692.0);
	Employee e3=new Employee("Sankarappa","Account",99999.0);
	Employee e4=new Employee("Akash","CA accout",88899.0);
	TreeSet<Employee>t=new TreeSet<>();
	t.add(e1);
	t.add(e2);
	t.add(e3);
	t.add(e4);
	for(Employee s:t) {
		System.out.println(s);
	}
}
}
