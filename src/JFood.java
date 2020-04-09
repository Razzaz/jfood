
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
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "M0chabear", 2019, 3, 26));
        DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Rama", "rama@ui.ac.id", "terserah"));

        System.out.println("List Customer: ");
        for (Customer customer : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customer.getName());
        }

        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "BM50", 1999, 10000, false));
        DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "BM51", 10000, 11000, false));

        System.out.print("\n");
        System.out.println("List Promo: ");
        for (Promo promo : DatabasePromo.getPromoDatabase())
        {
            System.out.println(promo);
        }

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 241000, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso Urat", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 1000, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Nasi Goreng", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 15000, FoodCategory.Rice));

        ArrayList<Food> food1 = new ArrayList<Food>();
        food1.add(DatabaseFood.getFoodById(1));
        food1.add(DatabaseFood.getFoodById(2));

        ArrayList<Food> food2 = new ArrayList<Food>();
        food2.add(DatabaseFood.getFoodById(3));
        food2.add(DatabaseFood.getFoodById(2));

        System.out.print("\n");
        System.out.println("List Food Category Noodles: ");
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.Noodles))
        {
            System.out.println(food);
        }

        DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), 1001));
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();

        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food2, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(1)));
        DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();

        System.out.print("\n");
        System.out.println("List Invoice: ");
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice);
        }

        DatabaseInvoice.changeInvoiceStatus(DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).getId(), InvoiceStatus.Finished);
        DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food2, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoByCode("BM50")));
        DatabasePromo.activatePromo(1);

        System.out.println("\nList invoice:");
        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            invoice.setTotalPrice();
            System.out.println(invoice);
            System.out.println();
        }


    }   
}