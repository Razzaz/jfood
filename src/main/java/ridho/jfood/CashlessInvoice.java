package ridho.jfood;

import java.text.*;
import java.util.ArrayList;

/**
 * class CashlessInvoice
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class CashlessInvoice extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice
     * @param id id
     * @param foods foods
     * @param customer customer
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }

    /**
     * Constructor for objects of class CashlessInvoice
     * @param id id
     * @param foods foods
     * @param customer customer
     * @param promo promo
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id, foods, customer);
        this.promo = promo;
    }

    /**
     * Get payment type
     * @return PAYMENT_TYPE
     */
    @Override
    public PaymentType getPaymentType(){
        return PAYMENT_TYPE;
    }

    /**
     * Get promo
     * @return promo
     */
    public Promo getPromo(){
        return promo;
    }

    /**
     * Set promo
     * @param  promo promo
     */
    public void setPromo(Promo promo){
        this.promo=promo;
    }

    /**
     * Set total price
     */
    public void setTotalPrice() {
        super.totalPrice=0;
        for(Food foods : getFoods())
        {
            super.totalPrice=super.totalPrice+foods.getPrice();
        }
        if(super.totalPrice>=promo.getMinPrice() && promo.getActive()) {
            super.totalPrice = super.totalPrice - promo.getDiscount();
            if(super.totalPrice < 0){
                super.totalPrice = 0;
            }
        }
    }

    /**
     * Method toString
     */
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
