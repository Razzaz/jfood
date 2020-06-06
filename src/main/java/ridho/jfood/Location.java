package ridho.jfood;

/**
 * class Location
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class Location
{
    private String province;
    private String description;
    private String city;

    /**
     * Constructor for objects of class Customer
     * @param city city
     * @param province province
     * @param description description
     */
    public Location(String city, String province, String description)
    {
        this.city = city;
        this.province = province;
        this.description = description;
    }

    /**
     * Get province
     * @return province
     */
    public String getProvince()
    {
        return province;
    }

    /**
     * Get city
     * @return city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Get description
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Set province
     * @param province province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }

    /**
     * Set city
     * @param city city
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * Set description
     * @param description description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Method toString
     */
    public String toString(){
        return "Province = " + province + "\nDescription = " + description + "\nCity = " + city;
    }
}
