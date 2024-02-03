package typecsating;

class Person{
String name="Tom";
void work() {
	System.out.println("Person walking");
}
}
class Student1 extends Person{
	void student() {
		System.out.println("Studing");
	}
}
public class UpDownCasting {
public static void main(String[] args) {
Person p=new Student1();
System.out.println(p.name);
p.work();
System.out.println("--------------------------------");
Student1 s=(Student1)p;
System.out.println(s.name);
s.work();
s.student();
}
}
