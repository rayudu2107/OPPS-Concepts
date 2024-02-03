package has_arelation;

class Student {
    String name;
    int id;
    int nbo;
    String branch;

    public Student(String name, int id, int nbo, String branch) {
        this.name = name;
        this.id = id;
        this.nbo = nbo;
        this.branch = branch;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("No of Books: " + nbo);
        System.out.println("Branch: " + branch);
    }
}

class Library {
    static Student student = new Student("Hari", 101, 2, "EC");

    public static void issueBook() {
        System.out.println("Book is issued to " + student.name);
    }
}

public class Aggregation {
    public static void main(String[] args) {
        Library.student.showDetails();
        Library.issueBook();
    }
}
