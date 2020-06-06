package ridho.jfood;

import java.util.ArrayList;

/**
 * class DatabaseFood
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class DatabaseFood
{
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastId = 0;

    /**
     * Get food database
     * @return FOOD_DATABASE
     */
    public static ArrayList<Food> getFoodDatabase(){
        return FOOD_DATABASE;
    }

    /**
     * Get last id
     * @return lastId
     */
    public static int getLastId(){
        return lastId;
    }

    /**
     * Get food by id.
     * @param id id
     * @return foods
     * @throws FoodNotFoundException the food not found exception
     */
    public static Food getFoodById(int id) throws FoodNotFoundException{
        for (Food foods : FOOD_DATABASE) {
            if (foods.getId() == id) {
                return foods;
            }
        }
        throw new FoodNotFoundException(id);
    }

    /**
     * Get seller by sellerId.
     * @param sellerId id seller
     * @return list
     */
    public static ArrayList<Food> getFoodBySeller(int sellerId){
        ArrayList<Food> list = new ArrayList<>();
        for (Food food : FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                list.add(food);
            }
        }
        return list;
    }

    /**
     * Get food by category.
     * @param category category
     * @return list
     */
    public static ArrayList<Food> getFoodByCategory(FoodCategory category){
        ArrayList<Food> list = new ArrayList<>();
        for (Food food : FOOD_DATABASE) {
            if (food.getCategory() == category) {
                list.add(food);
            }
        }
        return list;
    }

    /**
     * Add food.
     * @param food food
     * @return boolean
     */
    public static boolean addFood(Food food){
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }

    /**
     * Remove food boolean.
     * @param id id
     * @return boolean
     * @throws FoodNotFoundException the food not found exception
     */
    public static boolean removeFood(int id) throws FoodNotFoundException{
        for(int i = 0; i < FOOD_DATABASE.size(); i++){
            Food food = FOOD_DATABASE.get(i);
            if (food.getId() == id){
                FOOD_DATABASE.remove(i);
                return true;
            }
        }
        throw new FoodNotFoundException(id);
    }

}