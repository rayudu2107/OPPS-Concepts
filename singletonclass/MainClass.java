package singletonclass;
class Account{
//Rule-1
	private Account() {
		System.out.println("Object Created");
	}
	//Rule-3
	private static Account obj;//obj=null;
	//Rule-2
	public static void createObject() {
		if(obj==null) {
			obj=new Account();
	}
	else {
		System.out.println("Coannot Create object");
	}
}
}
public class MainClass {
public static void main(String[] args) {
	Account.createObject();
	Account.createObject();
}
}
