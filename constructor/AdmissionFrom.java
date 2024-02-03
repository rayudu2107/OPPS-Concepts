
package constructor;

public class AdmissionFrom {
	String name;
	long phno;
	String email;
	String password;
	String degree;
	String  yop;
	public AdmissionFrom(String name, long phno, String email, String password, String degree, String yop) {
		this.name = name;
		this.phno = phno;
		this.email = email;
		this.password = password;
		this.degree = degree;
		this.yop = yop;
	}//this keyword used to difference between local variable and member variable within a method/constructor. 
	void display() {
		System.out.println(name);
		System.out.println(phno);
		System.out.println(email);
		System.out.println(password);
		System.out.println(degree);
		System.out.println(yop);
	}
	public static void main(String[] args) {
		AdmissionFrom s1=new AdmissionFrom("PRADEEP",6360136630L,"Pradeepkumer2107@gmail.com","QWERTY@123","MSC","2022");
		AdmissionFrom s2=new AdmissionFrom("HARESH",7799082210L,"Hareshhare7799@gmail.com","Hare@123","PUC","2014");
		s1.display();
		System.out.println("====================================");
		s2.display();
	}
	
}
