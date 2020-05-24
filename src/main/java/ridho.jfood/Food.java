package ridho.jfood;

public class Food
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private int price;
    private Seller seller;
    private FoodCategory category;
    
    /**
     * Constructor for objects of class Food
     */
    public Food(int id, String name, Seller seller, int price, FoodCategory category)
    {
        // initialise instance variables
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param    a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getId()
    {
        // put your code here
        return id;
    }
    
    public String getName()
    {
        // put your code here
        return name;
    }
    
    public Seller getSeller()
    {
        return seller;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public FoodCategory getCategory()
    {
        return category;
    }
    
    public void setId(int id)
    {
       this.id = id;
    }
    
    public void setName(String name)
    {
       this.name = name;
    }
    
    public void setSeller(Seller seller)
    {
       this.seller = seller;
    }
    
    public void setPrice(int price)
    {
       this.price = price;
    }
    
    public void setCategory(FoodCategory category)
    {
       this.category = category;
    }
    
    public String toString()
    {
       return  "\nID       : " + id +
               "\nSeller   : " + getSeller().getName() +
               "\nFood     : " + getName() +
               "\nCity     : " + getSeller().getLocation().getCity() +
               "\nPrice    : " +price +
               "\nCategory : " + category;
    }
}

