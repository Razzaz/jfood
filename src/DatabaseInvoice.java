import java.util.ArrayList;

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Invoice getInvoiceById(int id){
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId){
        ArrayList<Invoice> list = new ArrayList<>();
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getCustomer().getId() == customerId) {
                list.add(invoice);
            }
        }
        return list;
    }

    public static boolean addInvoice(Invoice invoice){
        int customerId = invoice.getCustomer().getId();
        for(Invoice invoices : INVOICE_DATABASE){
            if (invoices.getCustomer().getId() == customerId  && invoices.getInvoiceStatus() == InvoiceStatus.Ongoing) {
                return false;
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus){
        for(Invoice invoices : INVOICE_DATABASE){
            if((invoices.getId() == id) && (invoices.getInvoiceStatus().equals(InvoiceStatus.Ongoing))){
                invoices.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id) {
        for (int i = 0; i < INVOICE_DATABASE.size(); i++) {
            Invoice invoice = INVOICE_DATABASE.get(i);
            if (invoice.getId() == id) {
                INVOICE_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }
}
