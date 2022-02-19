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
import models.Department;

/**
 *
 * @author LENOVO
 */
public class DepartmentDAO {

    private Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM Department";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Department department = new Department(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                );

                department.setDepartmentId(resultSet.getInt(1));
                department.setDepartmentName(resultSet.getString(2));
                department.setDepartmentManager(resultSet.getInt(3));
                department.setDepartmentLocation(resultSet.getInt(4));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    public boolean delete(Department department) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM DEPARTMENT WHERE id = ?");
            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert(Department department) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO department(id, "
                    + "name, "
                    + "manager, "
                    + "location) "
                    + "VALUES(?,?,?,?)");
            preparedStatement.setInt(1, department.getDepartmentId());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setInt(3, department.getDepartmentManager());
            preparedStatement.setInt(4, department.getDepartmentLocation());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Department getById(int id) {
        String query = "SELECT * FROM department where id = ?";
        Department department = new Department();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                department.setDepartmentId(rs.getInt(1));
                department.setDepartmentName(rs.getString(2));
                department.setDepartmentManager(rs.getInt(3));
                department.setDepartmentLocation(rs.getInt(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    public boolean update(int id, Department department) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE department SET name=?, "
                    + "manager=?, "
                    + "location=?, "
                    + "WHERE id=?");
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getDepartmentManager());
            preparedStatement.setInt(3, department.getDepartmentLocation());
            preparedStatement.setInt(4, id);

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
