package ridho.jfood;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseCustomerPostgre extends DatabaseConnection {

    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();

    public static ArrayList<Customer> getDatabaseCustomer() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Customer customer = null;
        try {
            String sql = "SELECT * FROM customer;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
                customer = new Customer(id, name, email, password);
                CUSTOMER_DATABASE.add(customer);
            }
            stmt.close();
            c.close();
            //customer = new Customer(id, name, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CUSTOMER_DATABASE;
    }

    public static Customer insertCustomer(String name, String email, String password) {
        Connection c = connection();
        PreparedStatement stmt;
        Customer customer = null;
        try {
            String sql = "INSERT INTO customer (name, email, password) VALUES (?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            ResultSet rs = stmt.executeQuery();
            int id = 1;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            customer = new Customer(id, name, email, password);
            stmt.close();
            c.close();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static int getLastCustomerId() {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        try {
            String sql = "SELECT id FROM customer;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            stmt.close();
            c.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static Customer getCustomer(int id_cust) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Customer customer = null;
        try {
            String sql = "SELECT * FROM customer WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id_cust);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
            }
            stmt.close();
            c.close();
            customer = new Customer(id, name, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static Customer getCustomer(String email_cust, String password_cust) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        Customer customer = null;
        try {
            String sql = "SELECT id, name, email, password, joindate FROM customer WHERE email=? AND password=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, email_cust);
            stmt.setString(2, password_cust);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email = rs.getString("email");
                password = rs.getString("password");
            }
            stmt.close();
            c.close();
            customer = new Customer(id, name, email, password);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static boolean removeCustomer(int id) {
        Connection c = connection();
        PreparedStatement stmt;
        try {
            String sql = "DELETE FROM customer WHERE id=?;";
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            c.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}