/**
 * Class CashInvoice is a class that manage about the transaction in JFood.
 *
 * @author Ridho Adhadi Gani
 * @version 
 */
public class CashInvoice extends Invoice
{
 
    private static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee = 0;
    
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, date, customer, invoiceStatus);
    }
    
    public CashInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id, food, date, customer, invoiceStatus);
        this.deliveryFee = deliveryFee;
    }

    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    
    public void setTotalPrice()
    {
     
        if (getDeliveryFee() != 0)
        {
            this.totalPrice = (getFood().getPrice() + getDeliveryFee());
        }
        else
        {
            this.totalPrice = getFood().getPrice();
        }
        
    }
        
    public void printData()
    {
    
        System.out.println("================INVOICE================");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getFood().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Customer: " + getCustomer().getName());
        System.out.println("Delivery Fee: " + getDeliveryFee());
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Status: " + getInvoiceStatus());
        System.out.println("Payment Type: " + getPaymentType());
   
    }
}