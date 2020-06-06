package ridho.jfood;

/**
 * class PromoCodeAlreadyExistsException
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class PromoCodeAlreadyExistsException extends Exception {
    private Promo promo_error;

    /**
     * Constructor for objects of class PromoCodeAlreadyExistsException
     * @param promo_input promo input
     */
    public PromoCodeAlreadyExistsException(Promo promo_input) {
        super("Promo Code : ");
        this.promo_error = promo_input;
    }

    /**
     * Get message
     * @return error message
     */
    @Override
    public String getMessage()
    {
        return super.getMessage() + promo_error.getCode() + " already exists";
    }
}
