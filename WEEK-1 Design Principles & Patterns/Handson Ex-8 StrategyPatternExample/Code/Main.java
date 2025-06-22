public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        System.out.println("== Paying with Credit Card ==");
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "Vineela"));
        context.processPayment(250.75);

        System.out.println("\n== Paying with PayPal ==");
        context.setPaymentStrategy(new PayPalPayment("vineela@example.com"));
        context.processPayment(89.99);
    }
}

