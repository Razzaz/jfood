
/**
 * Write a description of class JFood here.
 *
 * @author Ridho Gani
 * @version 5/3/2020
 */

import java.util.*;
import java.util.regex.*;
import java.text.*;

public class JFood
{
    public static void main(String args[])
    {
        Location location1 = new Location("Lampung", "Banyak Kopi", "Bandar Lampung");
        Seller seller1 = new Seller(1, "Ridho Gani", "ridhoadhadigani@gmail.com", "082123054525", location1);
        Seller seller2 = new Seller(2, "Gani Ridho", "ridhoadhadigani@gmail.com", "082123054525", location1);
        
        Calendar calendar = new GregorianCalendar(2020, 1, 3);
        Customer customer1 = new Customer(1, "Mocha", "mocha@bear.com", "m1lkbeaR", calendar);
        Customer customer2 = new Customer(2, "Milk", "milk@bear.com", "M0chabear", 2019, 3, 26);
        Customer customer3 = new Customer(3, "Fluffy", "fluffy@notabear.com", "terserah");
        
        Promo promo1 = new Promo(1, "1330", 1999, 10000, true);
        Food food1 = new Food(1,"Bakso", seller1, 25000, FoodCategory.Noodles);
        Food food2 = new Food(2,"Bakso Urat", seller1, 1000, FoodCategory.Noodles);
        
        CashlessInvoice cashlessInvoice1 = new CashlessInvoice(1, food1, customer1, InvoiceStatus.Ongoing);
        //CashlessInvoice cashlessInvoice2 = new CashlessInvoice(2, food2, "20 Maret 2020", customer2, InvoiceStatus.Finished);
        //CashlessInvoice cashlessInvoice3 = new CashlessInvoice(3, food2, "21 Maret 2020", customer3, InvoiceStatus.Finished, promo1);
        //CashlessInvoice cashlessInvoice4 = new CashlessInvoice(4, food1, "19 Maret 2020", customer1, InvoiceStatus.Finished, promo1); 
        CashInvoice cashInvoice1 = new CashInvoice(1, food2, customer2, InvoiceStatus.Finished);
        //CashInvoice cashInvoice2 = new CashInvoice(1, food1, "20 Maret 2020", customer1, InvoiceStatus.Finished, 4000);
        
        cashlessInvoice1.setTotalPrice();
        cashInvoice1.setTotalPrice();
        
        //System.out.println(customer1.toString()+"\n");
        //System.out.println(customer2.toString()+"\n");
        //System.out.println(customer3.toString()+"\n");
        
        System.out.println(cashlessInvoice1.toString());
        System.out.println(cashInvoice1.toString());
    }   
}