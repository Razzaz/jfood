package ridho.jfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) throws SellerNotFoundException, FoodNotFoundException, PromoCodeAlreadyExistsException {

        Location location1 = new Location("Jakarta Pusat", "Jakarta", "Daerah Khusus Ibukota");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "082123054525", location1));

        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 24000, FoodCategory.Noodles));
        DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Bakso Urat", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 20000, FoodCategory.Noodles));

        //DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Ridho Gani", "ridhoadhadigani@gmail.com", "M0chabear", 2019, 3, 26));
        //DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Rama", "rama@ui.ac.id", "terserah"));

        //ArrayList<Food> food1 = new ArrayList<Food>();
        //food1.add(DatabaseFood.getFoodById(1));
        //food1.add(DatabaseFood.getFoodById(2));

        DatabasePromo.addPromo(new Promo(1, "BM50", 1000, 500, true));
        DatabasePromo.addPromo(new Promo(2, "BM51", 2000, 100, true));

        //DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoByCode("BM50")));
        //DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId()+1, food1, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoByCode("BM50")));
        //DatabaseInvoice.getInvoiceByCustomer(1).get(DatabaseInvoice.getInvoiceByCustomer(1).size()-1).setTotalPrice();

        DatabaseCustomerPostgre.insertCustomer("ridho","ridhoo@gmail.com","Ridho123");

        SpringApplication.run(JFood.class, args);
    }

}