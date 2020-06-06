package ridho.jfood;

/**
 * class OngoingInvoiceAlreadyExistsException
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    /**
     * Constructor for objects of class OngoingInvoiceAlreadyExistsException
     * @param invoice_input invoice input
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input){
        super("\nOngoing Invoice : \n");
        this.invoice_error = invoice_input;
    }

    /**
     * Get message
     * @return error message
     */
    @Override
    public String getMessage(){
        return super.getMessage() + invoice_error.getFoods() + "already ordered by"+ invoice_error.getCustomer().getName()+"\n";
    }
}
