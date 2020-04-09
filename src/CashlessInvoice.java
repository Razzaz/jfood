
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
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id, foods, customer);
        this.promo = promo;
    }

    @Override
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
        super.totalPrice=0;
        for(Food foods : getFoods())
        {
            super.totalPrice=super.totalPrice+foods.getPrice();
        }
        if(super.totalPrice>=promo.getMinPrice() && promo.getActive()) {
            super.totalPrice = super.totalPrice - promo.getDiscount();
        }
    }

    @Override
    public String toString()
    {
        StringBuilder foodName = new StringBuilder();
        for (Food food: getFoods()){
            foodName.append(food.getName()).append(", ");
        }

        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getPromo() != null && getPromo().getActive() && totalPrice > getPromo().getMinPrice())
        {
            return "================Invoice================" + "\n" +
                   "ID          : " + getId() + "\n" +
                   "Name        : " + foodName + "\n" +
                   "Date        : " + date + "\n" +
                   "Customer    : " + getCustomer().getName() + "\n" +
                   "Promo       : " + getPromo().getCode() + "\n" +
                   "Total Price : " + totalPrice + "\n" +
                   "Status      : " + getInvoiceStatus() + "\n" +
                   "Payment Type: " + getPaymentType();
        }
        else{
            return "================Invoice================" + "\n" +
                   "ID          : " + getId() + "\n" +
                   "Name        : " + foodName + "\n" +
                   "Date        : " + date + "\n" +
                   "Customer    : " + getCustomer().getName() + "\n" +
                   "Total Price : " + totalPrice + "\n" +
                   "Status      : " + getInvoiceStatus() + "\n" +
                   "Payment Type: " + getPaymentType();
        }
    }
}
