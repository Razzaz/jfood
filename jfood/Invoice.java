/**
 * Write a description of class Invoice here.
 *
 * @author Ridho Gani
 * @version 5/3/2020
 */
public class Invoice
{
    private int id;
    private int idFood;
    private String date;
    private int totalPrice;
    private Customer customer;
    private PaymentType paymentType;
    private InvoiceStatus status;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, int idFood, String date, Customer customer, int totalPrice, InvoiceStatus status)
    {
        // initialise instance variables
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.customer = customer;
        this.totalPrice = totalPrice;
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
    public int getIdFood()
    {
        return idFood;
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
    public PaymentType getPaymentType()
    {
        return paymentType;
    }
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setIdFoods(int idFood)
    {
        this.idFood = idFood;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
    public void printData()
    {
       System.out.println("===============INVOICE===============");
       System.out.println("ID: " + getId());
       System.out.println("Food ID: " + getIdFood());
       System.out.println("Date: " + getDate());
       System.out.println("Customer: " + getCustomer().getName());
       System.out.println("Total Price: " + getTotalPrice());
        System.out.println("Status: " + getInvoiceStatus());
    }
}