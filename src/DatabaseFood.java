import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * DatabaseFood is class that contains a list of food.
 *
 * @author Ridho Adhadi Gani
 * @version 4/2/2020;
 */
public class DatabaseFood
{
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastId = 0;

    public static ArrayList<Food> getFoodDatabase(){
        return FOOD_DATABASE;
    }

    public static int getLastId(){
        return lastId;
    }

    public static Food getFoodById(int id){
        for (Food foods : FOOD_DATABASE) {
            if (foods.getId() == id) {
                return foods;
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId){
        ArrayList<Food> list = new ArrayList<>();
        for (Food food : FOOD_DATABASE) {
            if (food.getSeller().getId() == sellerId) {
                list.add(food);
            }
        }
        return list;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category){
        ArrayList<Food> list = new ArrayList<>();
        for (Food food : FOOD_DATABASE) {
            if (food.getCategory() == category) {
                list.add(food);
            }
        }
        return list;
    }

    public static boolean addFood(Food food){
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }

    public static boolean removeFood(int id){
        for(int i = 0; i < FOOD_DATABASE.size(); i++){
            Food food = FOOD_DATABASE.get(i);
            if (food.getId() == id){
                FOOD_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }

}