package abstracts;
//Abstract class representing a payment method
abstract class PaymentMethod {
 abstract void pay(double amount);
}

//Concrete subclass for Credit Card payment method
class CreditCard extends PaymentMethod {
 private String cardNumber;

 public CreditCard(String cardNumber) {
     this.cardNumber = cardNumber;
 }

 @Override
 void pay(double amount) {
     System.out.println("Paying Rs." + amount + " using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
 }
}

//Concrete subclass for Phonepay payment method
class PhonePay extends PaymentMethod {
 private String email;

 public PhonePay(String email) {
     this.email = email;
 }

 @Override
 void pay(double amount) {
     System.out.println("Paying Rs." + amount + " using PhonePay account " + email);
 }
}

//Buyer class to handle buying process
class Buyer {
 private PaymentMethod paymentMethod;

 public Buyer(PaymentMethod paymentMethod) {
     this.paymentMethod = paymentMethod;
 }

 public void buy(double amount) {
     paymentMethod.pay(amount);
 }
}

public class Shapping {
 public static void main(String[] args) {
     // Create instances of payment methods
     PaymentMethod creditCard = new CreditCard("1234567890123456");
     PaymentMethod phonePay = new PhonePay("example@example.com");

     // Create a buyer with a payment method
     Buyer buyer1 = new Buyer(creditCard);
     Buyer buyer2 = new Buyer(phonePay);

     // Buying process
     buyer1.buy(100);
     buyer2.buy(50);
 }
}
