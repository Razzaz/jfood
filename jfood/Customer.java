/**
 * Write a description of class Customer here.
 *
 * @author Ridho Gani
 * @version 5/3/2020
 */

import java.util.*;
import java.util.regex.*;
import java.text.*;

public class Customer
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private String email;
    private String password;
    private int year;
    private int month;
    private int dayOfMonth;
    private Calendar joinDate;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

    /**
     * Constructor for objects of class Customer
     */
    public Customer(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        
        setEmail(email);
        setPassword(password);
    }
    
    public Customer(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        this.joinDate = new GregorianCalendar(year,month-1,dayOfMonth);
        
        setEmail(email);
        setPassword(password);
    }
    
    public Customer(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = Calendar.getInstance();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getId()
    {
        // put your code here
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public Calendar getJoinDate()
    {
        return joinDate;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        String regex = "^([\\w\\&\\*_~]+\\.{0,1})+@[\\w][\\w\\-]*(\\.[\\w\\-]+)+$";
        if(Pattern.matches(regex,email)){
            this.email = email;
        }
        else{
            this.email = " ";
        }
    }
    public void setPassword(String password)
    {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        if(Pattern.matches(regex,password)){
            this.password = password;
        }
        else{
            this.password = " ";
        }
    }
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        this.joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    
    @Override
    public String toString()
    {
       if(joinDate == null)
       {
           return"Id:  "+id+"\nName: "+name+"\nEmail: "+email+"\nPassword: "+password+"\n";
       }
        
       else
       {   
           return "Id: " + id + "\nName: " + name + "\nEmail:  " + email + "\nPassword: " +password + "\nJoin Date: " + sdf.format(joinDate.getTime()).toString();
       }
    }
}