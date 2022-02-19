/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class EmployeeDAO {

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11)
                );

                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeFirstName(resultSet.getString(2));
                employee.setEmployeeLastName(resultSet.getString(3));
                employee.setEmployeeEmail(resultSet.getString(4));
                employee.setEmployeePhone(resultSet.getString(5));
                employee.setEmployeeHireDate(resultSet.getString(6));
                employee.setEmployeeJob(resultSet.getString(7));
                employee.setEmployeeSalary(resultSet.getDouble(8));
                employee.setEmployeeComission(resultSet.getDouble(9));
                employee.setEmployeeManager(resultSet.getInt(10));
                employee.setEmployeeDepartment(resultSet.getInt(11));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public boolean delete(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Employee WHERE id = ?");
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO employee(id, "
                    + "first_name, "
                    + "last_name, "
                    + "email, "
                    + "phone_number,"
                    + "hire_date,"
                    + "job,"
                    + "salary,"
                    + "comission_pct,"
                    + "manager,"
                    + "department) "
                    + "VALUES(?,?,?,?,?,TO_DATE(?, 'DD/MM/YYYY'),?,?,?,?,?)");
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeFirstName());
            preparedStatement.setString(3, employee.getEmployeeLastName());
            preparedStatement.setString(4, employee.getEmployeeEmail());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeHireDate());
            preparedStatement.setString(7, employee.getEmployeeJob());
            preparedStatement.setDouble(8, employee.getEmployeeSalary());
            preparedStatement.setDouble(9, employee.getEmployeeComission());
            preparedStatement.setInt(10, employee.getEmployeeManager());
            preparedStatement.setInt(11, employee.getEmployeeDepartment());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employee getById(int id) {
        String query = "SELECT * FROM employee where id = ?";
        Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeFirstName(resultSet.getString(2));
                employee.setEmployeeLastName(resultSet.getString(3));
                employee.setEmployeeEmail(resultSet.getString(4));
                employee.setEmployeePhone(resultSet.getString(5));
                employee.setEmployeeHireDate(resultSet.getString(6));
                employee.setEmployeeJob(resultSet.getString(7));
                employee.setEmployeeSalary(resultSet.getDouble(8));
                employee.setEmployeeComission(resultSet.getDouble(9));
                employee.setEmployeeManager(resultSet.getInt(10));
                employee.setEmployeeDepartment(resultSet.getInt(11));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public boolean update(int id, Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE employee SET first_name=?, "
                    + "last_name=?, "
                    + "email=?, "
                    + "phone_number=?, "
                    + "hire_date=?,"
                    + "job=?,"
                    + "salary=?,"
                    + "comission_pct=?,"
                    + "manager=?,"
                    + "department=? "
                    + "WHERE id=?");
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeFirstName());
            preparedStatement.setString(3, employee.getEmployeeLastName());
            preparedStatement.setString(4, employee.getEmployeeEmail());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeHireDate());
            preparedStatement.setString(7, employee.getEmployeeJob());
            preparedStatement.setDouble(8, employee.getEmployeeSalary());
            preparedStatement.setDouble(9, employee.getEmployeeComission());
            preparedStatement.setInt(10, employee.getEmployeeManager());
            preparedStatement.setInt(11, employee.getEmployeeDepartment());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
