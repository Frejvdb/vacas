package lasvacas.services;

import lasvacas.exceptions.PaymentException;
import lasvacas.models.Donor;
import lasvacas.models.Vaca;

public class PaymentService {
    private PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public boolean processPayment(Donor donor, Vaca vaca, double amount, String paymentMethod)
            throws PaymentException {
        
        boolean success = gateway.processPayment(amount, donor.getEmail(), paymentMethod);
        if (success) {
            vaca.receiveContribution(donor, amount);
            return true;
        } else {
            throw new PaymentException("Payment failed.");
        }
    }
}
