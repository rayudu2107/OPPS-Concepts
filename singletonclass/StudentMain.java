package singletonclass;
class Student{
	int age;
	String name;
	private Student(int age, String name) {
		this.age = age;
		this.name = name;
	}
	private static Student st;
	
	public static Student getInstance() {
		if(st==null) {
			st=new Student(24, "Pradeep");
		}
		return st; //return new Students(24, "Pradeep");
	}
	@Override
	public String toString() {
		return "Age:"+age+" Name:"+name;
	}
}
public class StudentMain {
	public static void main(String[] args) {
		Student st=Student.getInstance();
		System.out.println(st);
//		or
		System.out.println("Age:"+st.age+" Name:"+st.name);
	}
}
