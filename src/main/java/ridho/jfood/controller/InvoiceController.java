package ridho.jfood.controller;

import ridho.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * class InvoiceController
 * @author Ridho Gani
 * @version 6/6/2020
 */

@RequestMapping("/invoice")
@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
public class InvoiceController {

    /**
     * Get database invoice
     * @return DatabaseInvoice.getInvoiceDatabase()
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    /**
     * Get invoice by id
     * @param id id
     * @return DatabaseInvoice.getInvoiceById(id)
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id){
        return DatabaseInvoice.getInvoiceById(id);
    }

    /**
     * Get invoice by customer
     * @param customerId customer id
     * @return DatabaseInvoice.getInvoiceByCustomer(customerId)
     */
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer (@PathVariable int customerId) {
        return DatabaseInvoice.getInvoiceByCustomer(customerId);
    }

    /**
     * Get invoice by status
     * @param id customer id
     * @param invoiceStatus status
     * @return DatabaseInvoice.getInvoiceById(id)
     */
    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value="id") int id,
                                       @RequestParam(value="invoiceStatus") InvoiceStatus invoiceStatus) {
        DatabaseInvoice.changeInvoiceStatus(id, invoiceStatus);
        return DatabaseInvoice.getInvoiceById(id);
    }

    /**
     * Delete invoice by id
     * @param id customer id
     * @return DatabaseInvoice.removeInvoice(id)
     * @throws InvoiceNotFoundException invoice not found exceptions
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@RequestParam(value="id") int id) throws InvoiceNotFoundException {
        return DatabaseInvoice.removeInvoice(id);
    }

    /**
     * Create cash invoice
     * @param foodIdList food id
     * @param customerId customer id
     * @param deliveryFee delivery fee
     * @return invoice
     */
    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="deliveryFee", required = false, defaultValue = "0") int deliveryFee)
    {
        ArrayList<Food> foods = new ArrayList<>();
        for (int food : foodIdList) {
            try {
                foods.add(DatabaseFood.getFoodById(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId()+1, foods,
                    DatabaseCustomerPostgre.getCustomer(customerId), deliveryFee);
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalPrice();
            return invoice;
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Create cashless invoice
     * @param foodIdList food id
     * @param customerId customer id
     * @param promoCode promo code
     * @return invoice
     */
    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="foodIdList") ArrayList<Integer> foodIdList,
                                      @RequestParam(value="customerId") int customerId,
                                      @RequestParam(value="promoCode", required = false) String promoCode)
    {
        ArrayList<Food> foods = new ArrayList<>();
        for (int food : foodIdList) {
            try {
                foods.add(DatabaseFood.getFoodById(food));
            } catch (FoodNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, foods,
                    DatabaseCustomerPostgre.getCustomer(customerId), DatabasePromoPostgre.getPromo(promoCode));
            DatabaseInvoice.addInvoice(invoice);
            invoice.setTotalPrice();
            return invoice;
        } catch (OngoingInvoiceAlreadyExistsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
