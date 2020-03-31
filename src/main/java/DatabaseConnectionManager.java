import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private final String HOST;
    private final String USERNAME;
    private final String PASSWORD;

    public DatabaseConnectionManager() {
        this.HOST = "jdbc:mysql://localhost:3306/emp_dept";
        this.USERNAME = "root";
        this.PASSWORD = "****";
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(HOST,USERNAME, PASSWORD);
    }
}
