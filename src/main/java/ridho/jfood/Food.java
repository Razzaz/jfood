package ridho.jfood;

/**
 * class Food
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class Food
{
    private int id;
    private String name;
    private int price;
    private Seller seller;
    private FoodCategory category;

    /**
     * Constructor for objects of class Food
     * @param id food's id
     * @param name food's name
     * @param seller food's email
     * @param price food's password
     * @param category food's join date
     */
    public Food(int id, String name, Seller seller, int price, FoodCategory category)
    {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }

    /**
     * Get id
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Get name
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get seller
     * @return seller
     */
    public Seller getSeller()
    {
        return seller;
    }

    /**
     * Get price
     * @return price
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Get food category
     * @return category
     */
    public FoodCategory getCategory()
    {
        return category;
    }

    /**
     * Set id
     * @param id id
     */
    public void setId(int id)
    {
       this.id = id;
    }

    /**
     * Set name
     * @param name name
     */
    public void setName(String name)
    {
       this.name = name;
    }

    /**
     * Set seller
     * @param seller seller
     */
    public void setSeller(Seller seller)
    {
       this.seller = seller;
    }

    /**
     * Set price
     * @param price price
     */
    public void setPrice(int price)
    {
       this.price = price;
    }

    /**
     * Set category
     * @param category category
     */
    public void setCategory(FoodCategory category)
    {
       this.category = category;
    }

    /**
     * Method toString
     */
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

