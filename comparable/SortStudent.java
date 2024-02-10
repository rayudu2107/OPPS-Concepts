package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
class Student implements Comparable<Student>{
	String name;
	int marks;
	int age;
	String city;
	public Student(String name,int marks,int age,String city) {
	this.name=name;
	this.marks=marks;
	this.age=age;
	this.city=city;
	}
	public String toString() {
		return "Name: "+name+" Marks: "+marks+" "
				+ "Age: "+age+" City: "+city;
	}
	@Override
	public int compareTo(Student s) {
//			return this.name.compareTo(s.name);
		return this.age-s.age;
//		return this.marks-s.marks;
		}
}
public class SortStudent {
public static void main(String[] args) {
	Student s1=new Student("swathi",97,24,"Bellary");
	Student s2=new Student("harinath",80,22,"anantapur");
	Student s3=new Student("raju",83,26,"yadgir");
	Student s4=new Student("rajesh",99,23,"andhral");
//	TreeSet<Student>t=new TreeSet();
	ArrayList<Student>t=new ArrayList<Student>();
	t.add(s1);
	t.add(s2);
	t.add(s3);
	t.add(s4);
	Collections.sort(t);
	for(Student s:t) {
		System.out.println(s);
	}
}
}

//return this.name.compareTo(s.name);
//return this.age-s.age;
//return this.marks-s.marks;