package polymorphism;

public class Amazan {
	public  void purchase(int cast) {
		System.out.println("cast "+cast);
		}
		public void purchase(String brand) {
			System.out.println("brand "+brand);
		}
		public void purchase(int cast,String brand) {
			System.out.println("cast "+cast+" brand "+brand);
		}
		public void purchase(String brand,int cast){
			System.out.println(" brand "+brand+" cast "+cast);
		}
		public static void main(String[] args) {
			Amazan a=new Amazan();
			a.purchase(1000);
			a.purchase("mobile");
			a.purchase(2000,"tv");
			a.purchase("bike",900000);
		}
}
