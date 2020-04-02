
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

        DatabaseSeller.addSeller(new Seller(1, "Ridho Gani", "ridhoadhadigani@gmail.com", "082123054525", location1));
        DatabaseSeller.addSeller(new Seller(2, "Ridho Gani", "ridhoadhadigani@gmail.com", "082123054525", location1));
        DatabaseSeller.addSeller(new Seller(3, "Rama", "rama@gmail.com", "082123054525", location1));
        
        Calendar calendar = new GregorianCalendar(2020, 1, 3);
        DatabaseCustomer.addCustomer(new Customer(1, "Ridho Gani", "ridhoadhadigani@gmail.com", "m1lkbeaR", calendar));
        DatabaseCustomer.addCustomer(new Customer(2, "Ridho Gani", "ridhoadhadigani@gmail.com", "M0chabear", 2019, 3, 26));
        DatabaseCustomer.addCustomer(new Customer(3, "Rama", "rama@ui.ac.id", "terserah"));

        System.out.println("List Customer: ");
        for (Customer customer : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customer.getName());
        }
        System.out.print("\n");

        //Promo promo1 = new Promo(1, "1330", 1999, 10000, true);
        DatabaseFood.addFood(new Food(1,"Bakso", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 25000, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(2,"Bakso Urat", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 1000, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(2,"Nasi Goreng", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 15000, FoodCategory.Rice));

        System.out.println("List Food Category Noodles: ");
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Noodles))
        {
            System.out.println(food.getName());
        }

        //CashlessInvoice cashlessInvoice1 = new CashlessInvoice(1, food1, customer1, InvoiceStatus.Ongoing);
        //CashlessInvoice cashlessInvoice2 = new CashlessInvoice(2, food2, "20 Maret 2020", customer2, InvoiceStatus.Finished);
        //CashlessInvoice cashlessInvoice3 = new CashlessInvoice(3, food2, "21 Maret 2020", customer3, InvoiceStatus.Finished, promo1);
        //CashlessInvoice cashlessInvoice4 = new CashlessInvoice(4, food1, "19 Maret 2020", customer1, InvoiceStatus.Finished, promo1); 
        //CashInvoice cashInvoice1 = new CashInvoice(1, food2, customer2, InvoiceStatus.Finished);
        //CashInvoice cashInvoice2 = new CashInvoice(1, food1, "20 Maret 2020", customer1, InvoiceStatus.Finished, 4000);
        
        //cashlessInvoice1.setTotalPrice();
        //cashInvoice1.setTotalPrice();
        
        //System.out.println(customer1.toString()+"\n");
        //System.out.println(customer2.toString()+"\n");
        //System.out.println(customer3.toString()+"\n");
        
        //System.out.println(cashlessInvoice1.toString());
        //System.out.println(cashInvoice1.toString());
    }   
}