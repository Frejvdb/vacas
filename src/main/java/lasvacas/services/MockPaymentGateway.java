package lasvacas.services;

public class MockPaymentGateway implements PaymentGateway {

    @Override
    public boolean processPayment(double amount, String account, String method) {
        if (amount <= 0) {
            return false;
        }
        // Simulate a payment processing delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        return true;
    }
}
