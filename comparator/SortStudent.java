package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

class Student {
	int age;
	String name;
Double height;
	public Student(int age, String name,Double height) {
		this.age = age;
		this.name = name;
		this.height=height;
	}

	@Override
	public String toString() {
		return "Age: " + age + "Name :" + name+" height "+height+" feets!";
	}
}

class SortStudentByName implements Comparator<Student> {
	@Override
	public int compare(Student x, Student y) {
		return x.name.compareTo(y.name);
	}
}
class SortStudentByHeight implements Comparator<Student> {
	@Override
	public int compare(Student x, Student y) {
		return x.height.compareTo(y.height);
	}
}
public class SortStudent {
	public static void main(String[] args) {
		Student s1 = new Student(24, "Pradeep",6.0);
		Student s2 = new Student(26, "Haresh",5.5);
		Student s3 = new Student(20, "Rajesh",5.9);
		Student s4 = new Student(15, "Roshan",4.0);
//		TreeSet<Student> t = new TreeSet<Student>(new SortStudentByHeight());
		ArrayList<Student>t=new ArrayList<Student>();
		t.add(s1);
		t.add(s2);
		t.add(s3);
		t.add(s4);
		Collections.sort(t,new SortStudentByName());
		for (Student s : t) {
			System.out.println(s);
		}
	}
}

