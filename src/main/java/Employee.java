import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Employee implements Comparable<Employee> {
    private int empno;
    private String ename;
    private String job;
    private String mgr;
    private Date hiredate;
    private double sal;
    private String comm;
    private int deptno;

    public Employee() {
    }

    public Employee(int empno, String ename, String job, String mgr, Date hiredate, double sal, String comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    // The method returns a map with empno as key & the related employee object as value
    // Challenge: Print the map sorted by hiredate
    public HashMap<Integer, Employee> getAllEmployees() throws SQLException {
        // Laver mit HashMap
        HashMap<Integer, Employee> empHashMap = new HashMap<Integer, Employee>();

        // Laver et objekt af min database connection manager
        DatabaseConnectionManager conn = new DatabaseConnectionManager();

        // Opretter en forbindelse til MySQL database
        Connection forbindelseTilMySQL = conn.getConnection();

        // Opret statement – "fartøj" til query of resultatset
        Statement mitStatement = forbindelseTilMySQL.createStatement();

        // Opret query
        String getAllEmp = "select * from emp";
        // Eksekver query
        ResultSet allEmp = mitStatement.executeQuery(getAllEmp);

        while (allEmp.next()) {
            empHashMap.put(allEmp.getInt("empno"), new Employee(allEmp.getInt("empno"),
                    allEmp.getString("ename"), allEmp.getString("job"), allEmp.getString("mgr"),
                    allEmp.getDate("hiredate"), allEmp.getDouble("sal"),
                    allEmp.getString("comm"), allEmp.getInt("deptno")));
        }
        System.out.println(empHashMap);
        // Hvordan sorterer jeg et HashMap efter en attribut hos værdi-objektet?
        return empHashMap;
    }

    @Override
    public int compareTo(Employee e) {
        return getHiredate().compareTo(e.getHiredate());
    }

}
