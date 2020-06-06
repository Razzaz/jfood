package ridho.jfood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * class DatabasePromo
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class DatabasePromoPostgre extends DatabaseConnection {

    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<>();

    /**
     * Get promo database
     * @return PROMO_DATABASE
     */
    public static ArrayList<Promo> getDatabasePromo() {

        PROMO_DATABASE.clear();
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String code = null;
        int discount = 0;
        int minPrice = 0;
        boolean active = false;
        Promo promo = null;
        try {
            String sql = "SELECT * FROM promo;";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                code = rs.getString("code");
                discount = rs.getInt("discount");
                minPrice = rs.getInt("minPrice");
                active = rs.getBoolean("active");
                promo = new Promo(id, code, discount, minPrice, active);
                PROMO_DATABASE.add(promo);
            }
            stmt.close();
            c.close();
            //customer = new Customer(id, name, email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return PROMO_DATABASE;
    }

    /**
     * Insert promo
     * @param code code
     * @param discount discount
     * @param minPrice minimum price
     * @param active status
     * @return promo
     */
    public static Promo insertPromo(String code, int discount, int minPrice, boolean active) {
        Connection c = connection();
        PreparedStatement stmt;
        Promo promo = null;
        try {
            String sql = "INSERT INTO promo (code, discount, minPrice, active) VALUES (?,?,?,?) RETURNING id;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, code);
            stmt.setInt(2, discount);
            stmt.setInt(3, minPrice);
            stmt.setBoolean(4, active);
            ResultSet rs = stmt.executeQuery();
            int id = 1;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            promo = new Promo(id, code, discount, minPrice, active);
            stmt.close();
            c.close();
            return promo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return promo;
    }

    /**
     * Get promo by code
     * @param code_promo promo code
     * @return promo
     */
    public static Promo getPromo(String code_promo) {
        Connection c = connection();
        PreparedStatement stmt;
        int id = 0;
        String code = null;
        int discount = 0;
        int minPrice = 0;
        boolean active = false;
        Promo promo = null;
        try {
            String sql = "SELECT * FROM promo WHERE code=?;";
            stmt = c.prepareStatement(sql);
            stmt.setString(1, code_promo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                code = rs.getString("code");
                discount = rs.getInt("discount");
                minPrice = rs.getInt("minPrice");
                active = rs.getBoolean("active");
            }
            stmt.close();
            c.close();
            promo = new Promo(id, code, discount, minPrice, active);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return promo;
    }

}
