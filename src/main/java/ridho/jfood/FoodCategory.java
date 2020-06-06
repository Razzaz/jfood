package ridho.jfood;

/**
 * class enum FoodCategory
 * @author Ridho Gani
 * @version 6/6/2020
 */

public enum FoodCategory
{

    Beverages("Beverages"),
    Coffee("Coffee"),
    Western("Western"),
    Snacks("Snacks"),
    Rice("Rice"),
    Noodles("Noodles"),
    Bakery("Bakery"),
    Japanese("Japanese");
    
    private String category;

    /**
     * Constructor for objects of class FoodCategory
     * @param category food category
     */
    private FoodCategory(String category)
    {
        this.category = category;
    }

    /**
     * Method toString
     */
    public String toString()
    {
        return category;
    }
}