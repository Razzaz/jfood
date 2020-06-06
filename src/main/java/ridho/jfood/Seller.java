package ridho.jfood;

/**
 * class Seller
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class Seller
{
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Constructor for objects of class Seller
     * @param id seller's id
     * @param name seller's name
     * @param email seller's email
     * @param phoneNumber seller's password
     * @param location seller's join date
     */
    public Seller(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
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
     * Get email
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Get phone number
     * @return phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * Get location
     * @return location
     */
    public Location getLocation()
    {
        return location;
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
     * Set email
     * @param email email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Set phone number
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set location
     * @param location location
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }

    /**
     * Method toString
     */
    public String toString(){
        return "Id = " + id + "\nName = " + name + "\nPhone Number = " + phoneNumber + "\nLocation =" +location;
    }
}
