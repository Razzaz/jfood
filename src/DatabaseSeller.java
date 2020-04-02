import java.util.ArrayList;

/**
 * DatabaseSeller is class that contains a list of seller.
 *
 * @author Ridho Adhadi Gani
 * @version 4/2/2020
 */
public class DatabaseSeller
{
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<Seller>();
    private static int lastId = 0;

    public static ArrayList<Seller> getSellerDatabase(){
        return SELLER_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Seller getSellerById(int id){
        for (Seller seller : SELLER_DATABASE) {
            if (seller.getId() == id) {
                return seller;
            }
        }
        return null;
    }

    public static boolean addSeller(Seller seller){
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    public static boolean removeSeller(int id){
        for(int i = 0; i < SELLER_DATABASE.size(); i++){
            Seller seller = SELLER_DATABASE.get(i);
            if (seller.getId() == id){
                SELLER_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }

}