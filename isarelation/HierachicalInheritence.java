package isarelation;
class Account1 {
String name;
long Accno;
double bal;
	public Account1(String name,long Accno) {
	this.name=name;
	this.Accno=Accno;
	}
	void deposit(double amt) {
		if(amt>=0) {
			bal+=amt;
			System.out.println("depasited amount"+amt+"availabl balnces"+bal);
		}
		else
		{
			System.out.println("negative amount");
		}
	}
}
class Savings extends Account1{

	public Savings(String name, long Accno) {
		super(name, Accno);// super(); creates the object of superclass whenever object of subclass is created to 
		//inherit the properties.
	}
	void withdrawal(double amt) {
		if(amt>0&&bal>=amt) {
			bal-=amt;
			System.out.println("withdrawl amount"+amt+"availabl balnces"+bal);
		}
		else {
			System.out.println("insuffficent balance");
		}
	}
}
class Current extends Account1{
double mbal=5000;
	public Current(String name, long Accno) {
		super(name, Accno);
	}
	void withdrawal(double amt) {
		if(amt>0&&bal-mbal>=amt) {
			bal-=amt;
			System.out.println("withdrawl amount"+amt+"availabl balnces"+bal);
		}
		else {
			System.out.println("insuffficent balance available balnces"+bal);
		}
	}
	void chackbal(){
		System.out.println(bal);
	}
}
public class HierachicalInheritence {
public static void main(String[] args) {
	Savings S=new Savings("haresh",123456l);
	S.deposit(1000.0);
	S.withdrawal(900);
	Current c=new Current("hare",1234l);
	c.deposit(6000.0);
	c.withdrawal(1000);
	c.chackbal();
}
}
