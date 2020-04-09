/**
 * Class CashInvoice is a class that manage about the transaction in JFood.
 *
 * @author Ridho Adhadi Gani
 * @version 
 */

import java.lang.reflect.Array;
import java.time.*;
import java.text.*;
import java.util.ArrayList;

public class CashInvoice extends Invoice
{
 
    private static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee = 0;
    //private InvoiceStatus status = InvoiceStatus.Ongoing;
    
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }
    
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

    @Override
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