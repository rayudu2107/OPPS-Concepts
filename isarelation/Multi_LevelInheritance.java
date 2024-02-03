package isarelation;
class WhatsappV1{
	public void msg() {
		System.out.println("This is msg()");
	}
}
class WhatsappV2 extends WhatsappV1{
	public void voiceMsg() {
		System.out.println("This is voice msg()");
	}
}
class WhatsappV3 extends WhatsappV2{
	public void vedio() {
		System.out.println("This is vedio()");
	}
}
public class Multi_LevelInheritance {
public static void main(String[] args) {
	System.out.println("Whatsapp Version1");
	WhatsappV1 v1=new WhatsappV1();
	v1.msg();
	System.out.println("Whatsapp Version2");
	WhatsappV2 v2=new WhatsappV2();
	v2.msg();
	v2.voiceMsg();
	System.out.println("Whatsapp Version3");
	WhatsappV3 v3=new WhatsappV3();
	v3.msg();
	v3.voiceMsg();
	v3.vedio();
}
}
