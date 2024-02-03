package exceptionhandling.customexception;


import java.util.Scanner;

class InvalidAgeException extends Exception{
private	String message;

public InvalidAgeException(String message) {
	super();
	this.message = message;
}
public String getMessage() {
	return message;
}
}
public class Person {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Entr the age");
	int age=s.nextInt();
	if(age>=18) {
	System.out.println("Person is eligible to vote");
}
	else {
		try {
			throw new InvalidAgeException("invalid age");
			
		} catch (Exception e) {
          System.out.println(e.getMessage());
		}
	}
}
}

