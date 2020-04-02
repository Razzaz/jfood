/**
 * Class CashInvoice is a class that manage about the transaction in JFood.
 *
 * @author Ridho Adhadi Gani
 * @version 
 */

import java.time.*;
import java.text.*;

public class CashInvoice extends Invoice
{
 
    private static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee = 0;
    
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id, food, customer, invoiceStatus);
    }
    
    public CashInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, int deliveryFee)
    {
        super(id, food, customer, invoiceStatus);
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
        
    public String toString()
    {
    SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
    String date = format1.format(getDate().getTime());
    if (getDeliveryFee() != 0)
    {
        return "================Invoice================" + "\n" +
               "ID: " + getId() + "\n" +
               "Name: " + getFood().getName() + "\n" +
               "Date: " + date + "\n" +
               "Customer: " + getCustomer().getName() + "\n" +
               "Total Price: " + totalPrice + "\n" +
               "Status: " + getInvoiceStatus() + "\n" +
               "Payment Type: " + getPaymentType() + "\n" +
               "Delivery Fee: " + getDeliveryFee();
    }
    else
    {
        return "================Invoice================" + "\n" +
               "ID: " + getId() + "\n" +
               "Name: " + getFood().getName() + "\n" +
               "Date: " + date + "\n" +
               "Customer: " + getCustomer().getName() + "\n" +
               "Total Price: " + totalPrice + "\n" +
               "Status: " + getInvoiceStatus() + "\n" +
               "Payment Type: " + getPaymentType();                     
    }
    }
}