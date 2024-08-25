// 1. High level module must not depend on low level modules but both should depend on abstraction.
// 2. Details must depend on Abstraction and not vice-versa.

//Low - level Module
public class CreditCardPayment {
    void processPayment (double amount) {
        //some code
    }
}

//High - Level Module

public class OrderService {
    private CreditCardPayment paymentProcessor;

    OrderService () {
        this.paymentProcessor = new CreditCardPayment();
    }

    public void placeOrder(double amount) {
        // Other order processing logic
        paymentProcessor.processPayment(amount);
    }
}

// This OrderService is tight coupled with credit card payment class. It is ahrd to extend for multiple payment methods.


//Abstraction
public interface PaymentProcessor {
    void processPayment (double amount);
}

// Low - level module (detail)

public class CreditCardPayment implements PaymentProcessor{
    @Override
    void processPayment (void amount) {
        //some code
    }
}
public class StripePayment implements PaymentProcessor{
    @Override
    void processPayment (void amount) {
        //some code
    }
}

//High - level Module
public class OrderService {
    private PaymentProcessor paymentProcessor;

    OrderService () {
        this.paymentProcessor = new PaymentProcessor();
    }

    public void placeOrder (double amount) {
        paymentProcessor.processPayment(amount);
    }
}