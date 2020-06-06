package ridho.jfood;

/**
 * class CustomerNotFoundException
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class SellerNotFoundException extends Exception {
    private int seller_error;

    /**
     * Constructor for objects of class SellerNotFoundException
     * @param seller_input customer input
     */
    public SellerNotFoundException(int seller_input) {
        super("Seller ID : ");
        this.seller_error = seller_input;
    }

    /**
     * Get message
     * @return error message
     */
    @Override
    public String getMessage()
    {
        return super.getMessage() + seller_error + " not found.";
    }
}
