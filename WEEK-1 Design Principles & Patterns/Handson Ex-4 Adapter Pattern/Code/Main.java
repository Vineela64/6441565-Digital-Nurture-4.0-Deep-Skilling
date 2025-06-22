public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new Razorpay());

        System.out.println("== Payment Processing Starts ==");

        paypalProcessor.processPayment(100.0);
        razorpayProcessor.processPayment(80.75);

        System.out.println("== Payment Processing Complete ==");
    }
}
