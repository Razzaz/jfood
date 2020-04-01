
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Ridho Gani
 * @version 
 */

import java.time.*;
import java.text.*;

public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;
    
    public CashlessInvoice(int id, Food food, Customer customer,InvoiceStatus invoiceStatus)
    {
        super(id, food, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id, food, customer, invoiceStatus);
        this.promo = promo;
    }
    
    public PaymentType getPaymentType(){
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo(){
        return promo;
    }
    
    public void setPromo(Promo promo){
        this.promo=promo;
    }
    
    public void setTotalPrice(){
        if((promo != null) && (promo.getActive() == true) && (getFood().getPrice() > getPromo().getMinPrice())){
            super.totalPrice = (getFood().getPrice() - promo.getDiscount());
        }
        else{
            super.totalPrice = getFood().getPrice();
        }
    }
  
    public String toString()
    {
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getPromo() != null && getPromo().getActive() == true && getFood().getPrice() > getPromo().getMinPrice())
        {
            return "\n================Invoice================" + "\n" +
                   "ID: " + getId() + "\n" +
                   "Name: " + getFood().getName() + "\n" +
                   "Date: " + date + "\n" +
                   "Customer: " + getCustomer().getName() + "\n" +
                   "Promo: " + getPromo().getCode() + "\n" +
                   "Total Price: " + totalPrice + "\n" +
                   "Status: " + getInvoiceStatus() + "\n" +
                   "Payment Type: " + getPaymentType() + "\n";
        }
        else{
            return "\n================Invoice================" + "\n" +
                   "ID: " + getId() + "\n" +
                   "Name: " + getFood().getName() + "\n" +
                   "Date: " + date + "\n" +
                   "Customer: " + getCustomer().getName() + "\n" +
                   "Total Price: " + totalPrice + "\n" +
                   "Status: " + getInvoiceStatus() + "\n" +
                   "Payment Type: " + getPaymentType() + "\n";
        }
    }
}
