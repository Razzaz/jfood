package ridho.jfood;

import java.text.*;
import java.util.ArrayList;

/**
 * class CashInvoice
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class CashInvoice extends Invoice
{
 
    private static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee = 0;

    /**
     * Constructor for objects of class CashInvoice
     * @param id id
     * @param foods foods
     * @param customer customer
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }

    /**
     * Constructor for objects of class CashInvoice
     * @param id id
     * @param foods foods
     * @param customer customer
     * @param deliveryFee delivery fee
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

    /**
     * Get payment type
     * @return PAYMENT_TYPE
     */
    @Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }

    /**
     * Get delivery fee
     * @return deliveryFee
     */
    public int getDeliveryFee()
    {
        return deliveryFee;
    }

    /**
     * Set delivery fee
     * @param deliveryFee delivery fee
     */
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }

    /**
     * Set total price
     */
    @Override
    public void setTotalPrice()
    {
        super.totalPrice=0;
        for(Food foods : getFoods())
        {
            super.totalPrice=super.totalPrice+foods.getPrice();
        }
        super.totalPrice=super.totalPrice+deliveryFee;
    }

    /**
     * Method toString
     */
    @Override
    public String toString() {
        StringBuilder foodName = new StringBuilder();
        for (Food food: getFoods()){
            foodName.append(food.getName()).append(", ");
        }

        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getDeliveryFee() != 0) {
            return  "================Invoice================" + "\n" +
                    "ID          : " + getId() + "\n" +
                    "Name        : " + foodName + "\n" +
                    "Date        : " + date + "\n" +
                    "Customer    : " + getCustomer().getName() + "\n" +
                    "Total Price : " + totalPrice + "\n" +
                    "Status      : " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n" +
                    "Delivery Fee: " + getDeliveryFee();
        }
        else{
            return  "================Invoice================" + "\n" +
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