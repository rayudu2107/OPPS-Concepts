package variables;
/*
 1.if variable and local variable have same then compiler always preference to local variable
 2. member and local variable have same name we can access static method using className.memeberName
 3. member non static local variable have same name we can access non_static method using new className().memeberName
 4. member non static local variable have same name we can access non_static method using this.memeberName
 */
public class Member {
static int z1=100;
int a=1000;
int x=111;
public static void view() {
	int z1=200; //1
	System.out.println("Z1 value:"+z1);//2
}
public static void test() {
	int a=2000;
	System.out.println("a value:"+new Member().a);//3
	
}
public void cheack() {
	int x=222; 
	System.out.println("x value:"+this.x);//4
	
}
public static void main(String[] args) {
	view();
	test();
	new Member().cheack();
}
	
}
