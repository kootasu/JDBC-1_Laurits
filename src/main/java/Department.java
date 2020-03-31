import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class Department {
    private int deptno;
    private String dname;
    private String loc;

    public Department() {
    }

    public Department(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    /*

    // Department has a method: getSetOfDepartments
    // The method returns a set containing all department objects
    public static Set<Department> getSetOfDepartments(ResultSet departments) throws SQLException {
        // Laver mit HashSet
        Set<Department> departmentSet = new HashSet<Department>();
        // Snupper departments
        while (departments.next()) {
            departmentSet.add(new Department(departments.getInt("deptno"), departments.getString("dname"), departments.getString("loc")));
        }
        System.out.println(departmentSet.size());
        // Returner set
        return departmentSet;
    }

     */

    // Department has a method: getSetOfDepartments
    // The method returns a set containing all department objects
    public static Set<Department> getSetOfDepartments() throws SQLException {

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

        // Laver mit HashSet
        Set<Department> departmentSet = new HashSet<Department>();
        // Snupper departments
        while (allDepartments.next()) {
            departmentSet.add(new Department(allDepartments.getInt("deptno"), allDepartments.getString("dname"), allDepartments.getString("loc")));
        }
        System.out.println(departmentSet.size());
        // Returner set
        return departmentSet;
    }

}
