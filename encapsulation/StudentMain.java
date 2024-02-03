package encapsulation;
class Student{
	private String name;
	private int marks;
	private int reg;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getReg() {
		return reg;
	}
	public void setReg(int reg) {
		this.reg = reg;
	}
	
	
}
public class StudentMain {
public static void main(String[] args) {
	Student s=new Student();
	s.setName("PRADEEP");
	s.setReg(200040);
	s.setMarks(6255);
	System.out.println("Student Name:"+s.getName());
	System.out.println("Student Register Number:"+s.getReg());
	System.out.println("Student Marks:"+s.getMarks());
}
}
