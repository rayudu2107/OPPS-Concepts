package singletonclass;
class AdharCard {
	String name = "Pradeep";
	long number = 975008237381l;
	private AdharCard() {
		System.out.println("Adhar card is generated");
	}
	private static AdharCard ac;
	public static AdharCard getInstance() {
		if (ac == null) {
			ac = new AdharCard();
		}
		return ac;
	}
}
public class MainAdhar {
	public static void main(String[] args) {
		AdharCard ac = AdharCard.getInstance();
		System.out.println(ac.name + " adharcard number is " + ac.number);
		AdharCard ac1=AdharCard.getInstance();
		System.out.println(ac1.name + " adharcard number is " + ac1.number);
	}
}
