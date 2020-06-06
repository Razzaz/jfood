package ridho.jfood;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * class DatabaseConnection
 * @author Ridho Gani
 * @version 6/6/2020
 */

public class DatabaseConnection {
    protected static Connection connection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/jfood", "ridho", "cisco");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}

