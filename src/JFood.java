
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

        try{
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Rama", "rama@ui.ac.id", "terserah"));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Kharisma", "kharisma@ui.ac.id", "terserah"));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "m1lkbeaR", calendar));
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "M0chabear", 2019, 3, 26));
        }catch (EmailAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "BM50", 1999, 10000, false));
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "BM50", 10000, 11000, false));
        }catch (PromoCodeAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseCustomer.getCustomerById(10);
        } catch(CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.getFoodById(10);
        } catch(FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 241000, FoodCategory.Noodles));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Baksoo", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 251000, FoodCategory.Noodles));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso Urat", DatabaseSeller.getSellerById(5), 1000, FoodCategory.Noodles));
        }catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabasePromo.getPromoById(10);
        } catch(PromoNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n=========YANG MASUK DATABASE CUSTOMER==========");
        for(Customer customer : DatabaseCustomer.getCustomerDatabase()) {
            System.out.println(customer);
            System.out.println();
        }
        System.out.println("=========YANG MASUK DATABASE PROMO==========");
        for(Promo promo : DatabasePromo.getPromoDatabase()) {
            System.out.println(promo);
            System.out.println();
        }
        System.out.println("=========YANG MASUK DATABASE FOOD==========");
        for(Food food : DatabaseFood.getFoodDatabase()) {
            System.out.println(food);
            System.out.println();
        }

        ArrayList<Food> food1 = new ArrayList<Food>();
        try{
            food1.add(DatabaseFood.getFoodById(1));
            food1.add(DatabaseFood.getFoodById(2));
        }catch(FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), 1001));
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(2), 1001));
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(3), 1001));
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        for(Invoice invoices : DatabaseInvoice.getInvoiceDatabase()){
            new Thread(new PriceCalculator(invoices)).start();
        }

        System.out.println("\nList invoice:");
        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            invoice.setTotalPrice();
            System.out.println(invoice);
            System.out.println();
        }
    }   
}