package constructorchaining;

public class EmployeeLocal {
	EmployeeLocal(){
		System.out.println("Employee is working");
	}
EmployeeLocal(String name){
	this();
		System.out.println("Emloyee Name:"+name);
	}
EmployeeLocal(int id){
	this("Pradeep");
	System.out.println("Employee Id:"+id);
}
EmployeeLocal(long phno){
	this(17236);
	System.out.println("Employee Mobile No:"+phno);
}
public static void main(String[] args) {
	new EmployeeLocal(6360136630l);
}
}
