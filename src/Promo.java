/**
 * Write a description of class Invoice here.
 *
 * @author Ridho Gani
 * @version 
 */

public class Promo
{
    //Instance variables for Customer
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;
    
    public Promo(int id, String code, int discount, int minPrice, boolean active)
    {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }
    
    public int getId(){
        return id;
    }
    
    public String getCode(){
        return code;
    }
    
    public int getDiscount(){
        return discount;
    }
    
    public int getMinPrice(){
        return minPrice;
    }
    
    public boolean getActive(){
        return active;
    }
    
    //setter
    public void setId(int id){
        this.id = id;
    }
    
    public void setCode(String code){
        this.code = code;
    }
    
    public void setDiscount(int discount){
        this.discount = discount;
    }
    
    public void setMinPrice(int minPrice){
        this.minPrice = minPrice;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
    
    public void printData(){
        System.out.println("=========Promo==========");
        System.out.println("ID: "+id);
        System.out.println("Discount: "+discount);
        System.out.println("Code: "+code);
        System.out.println("Min Price: "+ minPrice);
        System.out.println("Active: "+active);
    }
    
    public String toString(){
        return "Id = " + id + "\nCode = " + code + "\nDiscount = " + discount + "\nMinPrice =" + minPrice + "\nActive =" + active;
    }
}