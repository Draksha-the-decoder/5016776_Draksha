public class StrategyPatternExample {

    public interface PaymentStrategy {
        void pay(int amount);
    }

    public static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String cardHolderName;
        private String cvv;
        private String expiryDate;

        public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expiryDate) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
            this.cvv = cvv;
            this.expiryDate = expiryDate;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card.");
        }
    }

    public static class PayPalPayment implements PaymentStrategy {
        private String emailId;
        private String password;

        public PayPalPayment(String emailId, String password) {
            this.emailId = emailId;
            this.password = password;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using PayPal.");
        }
    }

    public static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void pay(int amount) {
            paymentStrategy.pay(amount);
        }
    }

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("12345671154", "Draksha", "1987", "11/26");
        context.setPaymentStrategy(creditCardPayment);
        context.pay(1000);

        PaymentStrategy payPalPayment = new PayPalPayment("drak@gmail.com", "password");
        context.setPaymentStrategy(payPalPayment);
        context.pay(500);
    }
}

// OUTPUT

// Paid 1000 using Credit Card.
// Paid 500 using PayPal.