
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

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "082123054525", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "082123054525", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Rama", "rama@gmail.com", "082123054525", location1));
        
        Calendar calendar = new GregorianCalendar(2020, 1, 3);
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "m1lkbeaR", calendar));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridho Gani", "ridhoadhadigania@gmail.com", "M0chabear", 2019, 3, 26));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Rama", "rama@ui.ac.id", "terserah"));

        System.out.println("List Customer: ");
        for (Customer customer : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customer.getName());
        }
        System.out.print("\n");

        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "BM50", 1999, 10000, false));
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "BM50", 1888, 11000, true));

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 25000, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso Urat", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 1000, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Nasi Goreng", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 15000, FoodCategory.Rice));

        ArrayList<Food> food1 = new ArrayList<Food>();
        food1.add(DatabaseFood.getFoodById(1));
        food1.add(DatabaseFood.getFoodById(2));

        ArrayList<Food> food2 = new ArrayList<Food>();
        food2.add(DatabaseFood.getFoodById(3));
        food2.add(DatabaseFood.getFoodById(2));

        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), 1));
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food2, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(2)));

        ArrayList<Invoice> invoice1 = new ArrayList<Invoice>(DatabaseInvoice.getInvoiceByCustomer(1));
        int lastInvoice = 0;
        lastInvoice = invoice1.size();
        invoice1.get(lastInvoice-1).setTotalPrice();


        //CashlessInvoice cashlessInvoice = new CashlessInvoice(1,DatabaseFood.getFoodDatabase(), DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1));

        System.out.println("List Food Category Noodles: ");
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Noodles))
        {
            System.out.println(food.getName());
        }

        System.out.print("\n");
        System.out.println("List Promo: ");
        for (Promo promo : DatabasePromo.getPromoDatabase())
        {

            System.out.println(promo);
        }

        System.out.print("\n");
        System.out.println("List Invoice: ");
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice);
        }



        //System.out.println("Seller berdasarkan ID terakhir: "+DatabaseSeller.getSellerById(DatabaseSeller.getLastId()));
        //System.out.println(cashlessInvoice);


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