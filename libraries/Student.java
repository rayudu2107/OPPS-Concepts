package libraries;
//toString Example
public class Student {
int stuId;
String stuName;
public Student(int stuId, String stuName) {
	this.stuId = stuId;
	this.stuName = stuName;
}
@Override
	public String toString() {
		return "Student Name="+stuName+"  Student ID="+stuId;
	}
public static void main(String[] args) {
	//to string method returns string representation of an object
	Student s=new Student(101,"Pradeep");
//	System.out.println(s);//javalibraries.Student@75a1cd57
	System.out.println(s);
}
}
