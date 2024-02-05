package libraries;
//equals method example
public class Employee {
    int empId;
    String empName;

    public Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    @Override
    public boolean equals(Object obj) {
        Employee e2 = (Employee) obj;
        return this.empId == e2.empId && this.empName.equals(e2.empName);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "hare");
        Employee e2 = new Employee(101, "hare");
        System.out.println(e1+ "          "+e2);
        //by default equals method compare addresses or hashCode of two objects
        //order to compare data we have to override equals method
        System.out.println(e1.equals(e2));
        
        System.out.println("==============HashCode=============");
        //hashCode method used to return unique random number for an object.
        System.out.println(e1.hashCode());
    }
}
