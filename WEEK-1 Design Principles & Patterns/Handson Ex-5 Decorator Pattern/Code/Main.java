public class Main {
    public static void main(String[] args) {
        // Basic notifier - Email only
        Notifier emailNotifier = new EmailNotifier();

        // Email + SMS
        Notifier emailAndSMS = new SMSNotifierDecorator(emailNotifier);

        // Email + SMS + Slack
        Notifier fullNotifier = new SlackNotifierDecorator(emailAndSMS);

        System.out.println("== Sending Single Channel ==");
        emailNotifier.send("Your order has been shipped.");

        System.out.println("\n== Sending Two Channels ==");
        emailAndSMS.send("Your OTP is 123456.");

        System.out.println("\n== Sending All Channels ==");
        fullNotifier.send("System alert: High CPU usage detected.");
    }
}
