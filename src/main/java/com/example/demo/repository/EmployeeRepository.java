package com.example.demo.repository;

import com.example.demo.config.DatabaseConfigInit;
import com.example.demo.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    /**
     * @author Viacheslav Korbut
     * The code reads the data from the file "application.properties",
     * which contains configuration parameters for connection to the database,
     * and loads them into an object type Properties.
     * Properties and used to install a database connection.
     * This code provides storage of the connection configuration with the database in a separate file.
     * Used "try-with-resources" to automatically close the connection to the database after performing operations with them.
     */
    public static Connection getConnection() {
        Connection connection = null;

        String url = DatabaseConfigInit.getUrl();
        String user = DatabaseConfigInit.getUser();
        String password = DatabaseConfigInit.getPassword();

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        return connection;
    }

    public static int save(Employee employee) {
        int status = 0;
        try (Connection connection = EmployeeRepository.getConnection();
             PreparedStatement ps = connection
                     .prepareStatement("insert into users.users(name,email,country) values (?,?,?)")) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getCountry());

            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int update(Employee employee) {
        int status = 0;

        try (Connection connection = EmployeeRepository.getConnection();
             PreparedStatement ps = connection
                     .prepareStatement("update users.users set name=?,email=?,country=? where id=?")) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getCountry());
            ps.setInt(4, employee.getId());

            status = ps.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;

        try (Connection connection = EmployeeRepository.getConnection();
             PreparedStatement ps = connection
                     .prepareStatement("delete from users.users where id=?")) {

            ps.setInt(1, id);
            status = ps.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return status;
    }

    public static Employee getEmployeeById(int id) {
        Employee employee = new Employee();

        try (Connection connection = EmployeeRepository.getConnection();
             PreparedStatement ps = connection
                     .prepareStatement("select * from users.users where id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setEmail(rs.getString(3));
                employee.setCountry(rs.getString(4));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return employee;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> listEmployees = new ArrayList<>();

        try (Connection connection = EmployeeRepository.getConnection();
             PreparedStatement ps = connection
                     .prepareStatement("select * from users.users")) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();

                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setEmail(rs.getString(3));
                employee.setCountry(rs.getString(4));

                listEmployees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmployees;
    }
}
