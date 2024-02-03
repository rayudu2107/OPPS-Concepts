package exceptionhandling.customexception;

import java.util.Scanner;
class InvalidPasswordException extends Exception{
private String message;
InvalidPasswordException(String message){
	this.message=message;
}
@Override
public String getMessage() {
	return message;
}
}
public class Login {
		public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in);
			System.err.println("Enter the passward");
			int password=scanner.nextInt();
			if(password==123) {
				System.out.println("Login is successful");
			}
			else {
				try {
					throw new InvalidPasswordException("Invalid Password");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			scanner.close();
		}
	}
