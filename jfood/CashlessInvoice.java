
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Ridho Gani
 * @version 
 */
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;
    
    public CashlessInvoice(int id, Food food, String date, Customer customer,InvoiceStatus invoiceStatus)
    {
        super(id, food, date, customer, invoiceStatus);
    }
    
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
        super(id, food, date, customer, invoiceStatus);
        this.promo = promo;
    }
    
    public PaymentType getPaymentType(){
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo(){
        return promo;
    }
    
    public void setPromo(Promo promo){
        this.promo=promo;
    }
    
    public void setTotalPrice(){
        if((promo != null) && (promo.getActive() == true) && (getFood().getPrice() > getPromo().getMinPrice())){
            super.totalPrice = (getFood().getPrice() - promo.getDiscount());
        }
        else{
            super.totalPrice = getFood().getPrice();
        }
    }
  
    public void printData(){
        System.out.println("\n=========INVOICE==========");
        System.out.println("ID: "+ getId());
        System.out.println("Food: "+ getFood().getName());
        System.out.println("Date: "+ getDate());
        System.out.println("Customer: "+ getCustomer().getName());
        if(getFood().getPrice() != totalPrice){
            //artinya dia dapat promo, karena harga makanan promo akan berbeda
            //dengan harga yang tidak promo
            System.out.println("Promo: "+ promo.getCode());
        }
        System.out.println("Total price: "+ totalPrice);
        System.out.println("Status: "+ getInvoiceStatus());
        System.out.println("Payment Type: "+ getPaymentType());
    }
}
