/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author Ridho Adhadi Gani
 * @version
 */
public enum PaymentType
{
    Cash("Cash"), Cashless("Cashless");
    
    private String payment;
    
    private PaymentType(String payment)
    {
        this.payment = payment;
    }
    
    public String toString()
    {
        return payment;
    }
}