package thread;
class Pradeep extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("i:"+i);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Hari extends Thread{
@Override
public void run() {
	for(int i=6;i<=10;i++) {
		System.out.println("i:"+i);
	}
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}

public class CreateTC {
	public static void main(String[] args) {
		Pradeep pradeep=new Pradeep();
		pradeep.start();
//		System.out.println("====================================");
		Hari hari=new Hari();
		hari.start();
	}
}
