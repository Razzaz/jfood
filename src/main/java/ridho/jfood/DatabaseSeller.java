package ridho.jfood;

import java.util.ArrayList;

/**
 * class DatabaseSeller
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class DatabaseSeller
{
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<Seller>();
    private static int lastId = 0;

    /**
     * Get seller database
     * @return SELLER_DATABASE
     */
    public static ArrayList<Seller> getSellerDatabase(){
        return SELLER_DATABASE;
    }

    /**
     * Get last id
     * @return lastId
     */
    public static int getLastId(){
        return lastId;
    }

    /**
     * Get seller by id.
     * @param id id
     * @return seller
     * @throws SellerNotFoundException the seller not found exception
     */
    public static Seller getSellerById(int id) throws SellerNotFoundException{
        for (Seller seller : SELLER_DATABASE) {
            if (seller.getId() == id) {
                return seller;
            }
        }
        throw new SellerNotFoundException(id);
    }

    /**
     * Add seller boolean.
     * @param seller the id
     * @return boolean
     */
    public static boolean addSeller(Seller seller){
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    /**
     * Remove seller boolean.
     * @param id id
     * @return boolean
     * @throws SellerNotFoundException the seller not found exception
     */
    public static boolean removeSeller(int id) throws SellerNotFoundException{
        for(int i = 0; i < SELLER_DATABASE.size(); i++){
            Seller seller = SELLER_DATABASE.get(i);
            if (seller.getId() == id){
                SELLER_DATABASE.remove(i);
                return true;
            }
        }
        throw new SellerNotFoundException(id);
    }

}