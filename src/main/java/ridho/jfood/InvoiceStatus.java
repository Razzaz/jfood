package ridho.jfood;

/**
 * class enum InvoiceStatus
 * @author Ridho Gani
 * @version 6/6/2020
 */

public enum InvoiceStatus
{
    Ongoing("Ongoing"),
    Finished("Finished"),
    Cancelled("Cancelled");
    
    private String status;

    /**
     * Constructor for objects of class InvoiceStatus
     * @param status status
     */
    InvoiceStatus(String status)
    {
        this.status = status;
    }

    /**
     * Method toString
     */
    public String toString()
    {
        return status;
    }
}