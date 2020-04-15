package ridho.jfood;

import java.util.ArrayList;

public class DatabaseCustomer
{
    
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<>();

    private static int lastId = 0;

    public static ArrayList<Customer> getCustomerDatabase(){
        return CUSTOMER_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Customer getCustomerById(int id) throws CustomerNotFoundException{
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistsException{
        for(Customer customers : CUSTOMER_DATABASE){
            if (customers.getEmail().equals(customer.getEmail())) {
                throw new EmailAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException{
        for(int i = 0; i < CUSTOMER_DATABASE.size(); i++){
            Customer customer = CUSTOMER_DATABASE.get(i);
            if (customer.getId() == id){
                CUSTOMER_DATABASE.remove(i);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }
}