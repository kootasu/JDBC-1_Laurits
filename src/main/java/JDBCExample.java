import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) throws SQLException {

        // Laver et objekt af min database connection manager
        DatabaseConnectionManager conn = new DatabaseConnectionManager();

        // Opretter en forbindelse til MySQL database
        Connection forbindelseTilMySQL = conn.getConnection();

        // Opret statement – "fartøj" til query of resultatset
        Statement mitStatement = forbindelseTilMySQL.createStatement();

        // Opret query
        String getAllDepartments = "select * from dept";
        // Eksekver query
        ResultSet allDepartments = mitStatement.executeQuery(getAllDepartments);

        while (allDepartments.next()) {
            System.out.println(allDepartments.getInt("deptno"));
        }

        Employee e = new Employee();
        e.getAllEmployees();

        Department d = new Department();
        d.getSetOfDepartments();

    }
}
