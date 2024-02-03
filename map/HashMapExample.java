package map;

import java.util.HashMap;
import java.util.Set;

	class Student{
		String name;
		public Student(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Name:"+name;
		}
	}
	public class HashMapExample {
		public static void main(String[] args) {
			Student s1=new Student("haresh");
			Student s2=new Student("pradeep");
			Student s3=new Student("giiii");
			Student s4=new Student("giiii");
			HashMap<Student, Integer> map = new HashMap();
			map.put(s1,26);
			map.put(s2,24);
			map.put( s3,20);
			map.put(s4,22);
			Set<Student> k = map.keySet();
			for (Student i : k) {
				System.out.println(i + " Age is:" + map.get(i));
			}
		}
	}

