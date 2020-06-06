package ridho.jfood;

/**
 * class PriceCalculator
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class PriceCalculator implements Runnable {

    Invoice invoice;

    /**
     * Constructor for objects of class PriceCalculator
     * @param invoice food category
     */
    public PriceCalculator(Invoice invoice){
        this.invoice = invoice;
    }

    @Override
    public void run() {
        System.out.println("calculating invoice id: "+ invoice.getId());
        invoice.setTotalPrice();
        System.out.println("finish calculating invoice id: " + invoice.getId());
    }
}