package mod05_OYO_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manages database connections for the application.
 * Provides a utility to establish connections to the MySQL database.
 * 
 * @author angel
 */
public class DatabaseConnectionManager {
    
    // Database URL, Driver, Username, and Password constants
    private static final String DB_URL = "jdbc:mysql://localhost:3306/CMSC230";
    private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_Username = "root";
    private static final String DB_Password = "Password!!";

    // Static block to load the MySQL JDBC driver class
    static {
        try {
            Class.forName(DB_Driver);
        } catch (ClassNotFoundException e) {
            // Print error if the driver class cannot be found
            e.printStackTrace();
        }
    }

    /**
     * Establishes and returns a connection to the database.
     * 
     * @return A Connection object to interact with the database.
     * @throws SQLException If a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        // Get a connection to the MySQL database using the DriverManager
        return DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
    }
}
