package ridho.jfood;

/**
 * class enum PaymentType
 * @author Ridho Gani
 * @version 6/6/2020
 */

public enum PaymentType
{
    Cash("Cash"), Cashless("Cashless");
    
    private String payment;

    /**
     * Constructor for objects of class PaymentType
     * @param payment payment
     */
    private PaymentType(String payment)
    {
        this.payment = payment;
    }

    /**
     * Method toString
     */
    public String toString()
    {
        return payment;
    }
}