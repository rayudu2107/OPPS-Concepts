package thread;
class Amazan implements Runnable{
	@Override
	public void run() {
	System.out.println("Buying loptop");	
}
}
public class CreateRI {
public static void main(String[] args) {
	Amazan a=new Amazan();
	Thread t=new Thread(a);
	t.setName("PRADEEP");
	t.start();
	
	Amazan a1=new Amazan();
	Thread t1=new Thread(a1,"PRADEEP");
	t1.start();
	
	Thread t2=new Thread(new Amazan(),"PRADEEP");
	t2.start();
	
	new Thread(new Amazan(),"PRADEEP").start();
}
}
