package ridho.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) throws SellerNotFoundException, CustomerNotFoundException, FoodNotFoundException, OngoingInvoiceAlreadyExistsException, EmailAlreadyExistsException {

        Location location1 = new Location("Bandar Lampung", "Lampung", "Kopi");
        Location location2 = new Location("Jakarta Pusat", "Jakarta", "Macet");
        Location location3 = new Location("Jakarta Barat", "Jakarta", "Macet");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "082123054525", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Ridho", "ridhoadhadigani@gmail.com", "082123054525", location2));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "082123054525", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Rama", "rama@gmail.com", "082123054525", location3));

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 241000, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso Urat", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 1000, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso Buntut", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 1500, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Nasi Goreng", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 15000, FoodCategory.Rice));

        //DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "m1lkbeaR", calendar));
        //DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "M0chabear", 2019, 3, 26));
        //DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Rama", "rama@ui.ac.id", "terserah"));

        //ArrayList<Food> food1 = new ArrayList<Food>();
        //food1.add(DatabaseFood.getFoodById(1));
        //food1.add(DatabaseFood.getFoodById(2));

        //DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoByCode("BM50")));
        //DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoByCode("BM50")));

        SpringApplication.run(JFood.class, args);
    }

}