package db;
import java.sql.Connection;
import java.sql.DriverManager;

class ConnectionManager {
    static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost", "root", "1234");
    }

    static Connection getConnection(String dbName) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost" + dbName, "root", "1234");
    }
}