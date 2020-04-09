/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author Ridho Adhadi Gani
 * @version 13/3/2020
 */
public enum InvoiceStatus
{
    Ongoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private String status;
    
    InvoiceStatus(String status)
    {
        this.status = status;
    }
    
    public String toString()
    {
        return status;
    }
}