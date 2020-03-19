/**
 * Write a description of class Invoice here.
 *
 * @author Ridho Gani
 * @version 5/3/2020
 */
abstract class Invoice
{
    private int id;
    private Food food;
    private String date;
    protected int totalPrice;
    private Customer customer;
    private PaymentType paymentType;
    private InvoiceStatus status;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, Food food, String date, Customer customer, InvoiceStatus status)
    {
        // initialise instance variables
        this.id = id;
        this.food = food;
        this.date = date;
        this.customer = customer;
        this.status = status;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getId()
    {
        return id;
    }
    public Food getFood()
    {
        return food;
    }
    public String getDate()
    {
        return date;
    }
    public int getTotalPrice()
    {
        return totalPrice;
    }
    public Customer getCustomer()
    {
        return customer;
    }
    
    public abstract PaymentType getPaymentType();
    
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setFood(Food food)
    {
        this.food = food;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public abstract void setTotalPrice();
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
    public abstract void printData();
}