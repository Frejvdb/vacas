package lasvacas.services;

public interface PaymentGateway {
    boolean processPayment(double amount, String account, String method);
}
