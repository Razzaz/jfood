package ridho.jfood;

/**
 * class PromoNotFoundException
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class PromoNotFoundException extends Exception {
    private int promo_error;

    /**
     * Constructor for objects of class PromoNotFoundException
     * @param promo_input promo input
     */
    public PromoNotFoundException(int promo_input) {
        super("Promo ID : ");
        this.promo_error = promo_input;
    }

    /**
     * Get message
     * @return error message
     */
    @Override
    public String getMessage()
    {
        return super.getMessage() + promo_error + " not found.";
    }
}
