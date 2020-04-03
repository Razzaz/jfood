
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Ridho Gani
 * @version 
 */

import java.lang.reflect.Array;
import java.time.*;
import java.text.*;
import java.util.ArrayList;

public class CashlessInvoice extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;
    private InvoiceStatus status = InvoiceStatus.Ongoing;
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id, foods, customer);
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
    
    public void setTotalPrice() {
        for (Food foods: getFoods()) {
            if ((promo != null) && (promo.getActive()) && (foods.getPrice() >= getPromo().getMinPrice())) {
                super.totalPrice += (foods.getPrice() - promo.getDiscount());
            }
            else {
                super.totalPrice += foods.getPrice();
            }
        }
    }
  
    public String toString()
    {
        int tempPrice = 0;
        String foodName = "";
        for (Food food: getFoods()){
            tempPrice += food.getPrice();
            foodName += food.getName() + ", ";
        }

        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getPromo() != null && getPromo().getActive() && tempPrice > getPromo().getMinPrice())
        {
            return "\n================Invoice================" + "\n" +
                   "ID: " + getId() + "\n" +
                   "Name: " + foodName + "\n" +
                   "Date: " + date + "\n" +
                   "Customer: " + getCustomer().getName() + "\n" +
                   "Promo: " + getPromo().getCode() + "\n" +
                   "Total Price: " + tempPrice + "\n" +
                   "Status: " + getInvoiceStatus() + "\n" +
                   "Payment Type: " + getPaymentType() + "\n";
        }
        else{
            return "\n================Invoice================" + "\n" +
                   "ID: " + getId() + "\n" +
                   "Name: " + foodName + "\n" +
                   "Date: " + date + "\n" +
                   "Customer: " + getCustomer().getName() + "\n" +
                   "Total Price: " + totalPrice + "\n" +
                   "Status: " + getInvoiceStatus() + "\n" +
                   "Payment Type: " + getPaymentType() + "\n";
        }
    }
}
