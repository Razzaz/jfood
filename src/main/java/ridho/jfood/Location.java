package ridho.jfood;

public class Location
{
    // instance variables - replace the example below with your own
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Location
     */
    public Location(String city, String province, String description)
    {
        // initialise instance variables
        this.city = city;
        this.province = province;
        this.description = description;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getProvince()
    {
        // put your code here
        return province;
    }
    
    public String getCity()
    {
        // put your code here
        return city;
    }
    
    public String getDescription()
    {
        // put your code here
        return description;
    }
    
    public void setProvince(String province)
    {
        // put your code here
        this.province = province;
    }
    
    public void setCity(String city)
    {
        // put your code here
        this.city = city;
    }
    
    public void setDescription(String description)
    {
        // put your code here
        this.description = description;
    }
    
    public void printData()
    {
       System.out.println(province);
    }
    
    public String toString(){
        return "Province = " + province + "\nDescription = " + description + "\nCity = " + city;
    }
}
