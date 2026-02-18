package com.klu;
import java.sql.*;

public class JDBCCrud {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/fsad";
        String usr = "root";
        String pwd = "Pranathi15@2006";

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Connection Established");

            Statement st = con.createStatement();

            // Create Dept table
            String createDept =
                    "CREATE TABLE IF NOT EXISTS Dept (" +
                    "dept_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "dept_name VARCHAR(20)" +
                    ")";
            st.execute(createDept);
            System.out.println("Department table created");

            // Create Emp table
            String createEmp =
                    "CREATE TABLE IF NOT EXISTS Emp (" +
                    "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "emp_name VARCHAR(50), " +
                    "sal DOUBLE, " +
                    "dept_id INT, " +
                    "FOREIGN KEY (dept_id) REFERENCES Dept(dept_id)" +
                    ")";
            st.execute(createEmp);
            System.out.println("Employee table created");

            // Insert values into Dept table
            String insertDept1 = "INSERT INTO Dept (dept_name) VALUES ('HR')";
            String insertDept2 = "INSERT INTO Dept (dept_name) VALUES ('IT')";
            st.executeUpdate(insertDept1);
            st.executeUpdate(insertDept2);
            System.out.println("Department values inserted");

            // Insert values into Emp table
            String insertEmp1 =
                    "INSERT INTO Emp (emp_name, sal, dept_id) " +
                    "VALUES ('Ravi', 45000, 1)";
            String insertEmp2 =
                    "INSERT INTO Emp (emp_name, sal, dept_id) " +
                    "VALUES ('Anita', 60000, 2)";
            st.executeUpdate(insertEmp1);
            st.executeUpdate(insertEmp2);
            System.out.println("Employee values inserted");

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}