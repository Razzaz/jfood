/**
 * Write a description of class Invoice here.
 *
 * @author Ridho Gani
 * @version 5/3/2020
 */

import java.util.*;

public abstract class Invoice
{
    private int id;
    private ArrayList<Food> foods;
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    private PaymentType paymentType;
    private InvoiceStatus status;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, ArrayList<Food> foods, Customer customer)
    {
        // initialise instance variables
        this.id = id;
        this.foods = foods;
        this.date = Calendar.getInstance();
        this.customer = customer;
        this.status = InvoiceStatus.Ongoing;
    }


    public int getId()
    {
        return id;
    }
    
    public ArrayList<Food> getFoods()
    {
        return foods;
    }
    
    public Calendar getDate()
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
    
    public void setFoods(ArrayList<Food> foods)
    {
        this.foods = foods;
    }
    
    public void setDate(int year, int month, int dayOfMonth)
    {
        this.date.set(year, month, dayOfMonth);
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
    
    public abstract String toString();
}