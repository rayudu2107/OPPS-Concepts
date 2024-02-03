package thread;
public class Demo {
	public static void main(String[] args) {
		Thread t = new Thread();
		System.out.println("Id: " + t.getId());
		System.out.println("Name: " + t.getName());
        System.out.println("Priority:"+t.getPriority());
        
        System.out.println("==================");
        t.setName("Java Thread");
        t.setPriority(10);
    	System.out.println("Id: " + t.getId());
		System.out.println("Name: " + t.getName());
        System.out.println("Priority:"+t.getPriority());
        System.out.println("==================");
    	Thread tc = Thread.currentThread();
    	System.out.println("Id: " + tc.getId());
		System.out.println("Name: " + tc.getName());
        System.out.println("Priority:"+tc.getPriority());
	}
}
