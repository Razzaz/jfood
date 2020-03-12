
/**
 * Write a description of class JFood here.
 *
 * @author Ridho Gani
 * @version 5/3/2020
 */
public class JFood
{
    
    public static void main(String args[])
    {
        Location location1 = new Location("Lampung", "Banyak Kopi", "Bandar Lampung");
        Seller seller1 = new Seller(1, "Ridho Gani", "ridhoadhadigani@gmail.com", "082123054525", location1);
        Seller seller2 = new Seller(2, "Gani Ridho", "ridhoadhadigani@gmail.com", "082123054525", location1);
        Food food1 = new Food(1,"Bakso", seller1, 25000, FoodCategory.Noodles);
        Customer customer1 = new Customer(1, "Hary", "ridarth@gmail.com", "cisco", "06-03-2020");
        Invoice invoice1 = new Invoice(1, 1, "06-03-2020", customer1, 24000);
        //System.out.println(seller1.getName());
        //seller1.setName("Rama");
        //seller1.printData();
        food1.printData();
    } 

}