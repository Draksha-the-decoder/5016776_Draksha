public class AdapterPatternExample {

    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    public static class GooglePayGateway {
        public void makePayment(double amount) {
            System.out.println("Rs. " + amount + " processing through GooglePay.");
        }
    }

    public static class StripeGateway {
        public void charge(double amount) {
            System.out.println("Charging Rs." + amount + " through Stripe.");
        }
    }

    public static class GooglePayAdapter implements PaymentProcessor {
        private GooglePayGateway GooglePayGateway;

        public GooglePayAdapter(GooglePayGateway GooglePayGateway) {
            this.GooglePayGateway = GooglePayGateway;
        }

        @Override
        public void processPayment(double amount) {
            GooglePayGateway.makePayment(amount);
        }
    }

    public static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripeGateway;

        public StripeAdapter(StripeGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }

        @Override
        public void processPayment(double amount) {
            stripeGateway.charge(amount);
        }
    }

    public static void main(String[] args) {
        GooglePayGateway payPalGateway = new GooglePayGateway();
        StripeGateway stripeGateway = new StripeGateway();

        PaymentProcessor payPalAdapter = new GooglePayAdapter(payPalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);

        System.out.println("GooglePay Adapter:");
        payPalAdapter.processPayment(1000.0);

        System.out.println("\nStripe Adapter:");
        stripeAdapter.processPayment(2500.0);
    }
}

// OUTPUT

// GooglePay Adapter:
// Rs. 1000.0 processing through GooglePay.

// Stripe Adapter:
// Charging Rs.2500.0 through Stripe.
