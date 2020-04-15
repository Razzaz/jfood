package ridho.jfood;

public enum FoodCategory
{
    Beverages("Beverages"), Coffee("Coffee"), Western("Western"), Snacks("Snacks"), Rice("Rice"), Noodles("Noodles"), Bakery("Bakery"), Japanese("Japanese");
    
    private String category;
    
    private FoodCategory(String category)
    {
        this.category = category;
    }
    
    public String toString()
    {
        return category;
    }
}