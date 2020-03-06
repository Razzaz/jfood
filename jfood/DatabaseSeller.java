/**
 * DatabaseSeller is class that contains a list of seller.
 *
 * @author Ridho Adhadi Gani
 * @version 
 */
public class DatabaseSeller
{
    private String[] listSeller;
    
    /**
     * Constructor for objects of class DatabaseSeller
     */
    public DatabaseSeller()
    {
        
    }

    public boolean addSeller(Seller seller)
    {
        return false;
    }
    
    public boolean removeSeller(Seller seller)
    {
        return false;
    }
    
    /**
     * getListSeller() is used to return the current list of seller
     *
     * @return    listSeller that contains some String
     */
    public String[] getListSeller()
    {
        return listSeller;
    }
    
    public void setSeller(String[] listSeller)
    {
        this.listSeller = listSeller;
    }
    
}