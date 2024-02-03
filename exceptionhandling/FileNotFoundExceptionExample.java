package exceptionhandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileNotFoundExceptionExample {
public static void main(String[] args) {
	try {
		read();
	} catch (FileNotFoundException e) {
		System.out.println("File is not present");
	}
}
 static void read() throws FileNotFoundException  {
	FileReader f=new FileReader("Pradeep.txt");
}
}

