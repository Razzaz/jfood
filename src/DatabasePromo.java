import java.util.ArrayList;

/**
 * Write a description of class DatabasePromo here.
 *
 * @author Ridho Gani
 * @version 4/2/2020
 */
public class DatabasePromo
{
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<Promo>();
    private static int lastId = 0;

    public static ArrayList<Promo> getPromoDatabase(){
        return PROMO_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Promo getPromoById(int id){
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getId() == id) {
                return promo;
            }
        }
        return null;
    }

    public static Promo getPromoByCode(String code){
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getCode().equals(code)) {
                return promo;
            }
        }
        return null;
    }

    public static boolean addPromo(Promo promo){
        for(Promo promos : PROMO_DATABASE){
            if(promos.getCode().equals(promo.getCode())){
                return false;
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }

    public static boolean activatePromo(int id){
        for(Promo promo : PROMO_DATABASE) {
            if(promo.getId() == id) {
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }

    public static boolean deactivatePromo(int id){
        for (Promo promo : PROMO_DATABASE) {
            if (promo.getActive()) {
                promo.setActive(false);
                return true;
            }
        }
        return false;
    }

    public static boolean remove(int id){
        for(int i = 0; i < PROMO_DATABASE.size(); i++){
            Promo promo = PROMO_DATABASE.get(i);
            if (promo.getId() == id){
                PROMO_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }
}