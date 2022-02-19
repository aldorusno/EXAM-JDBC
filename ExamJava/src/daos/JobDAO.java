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
import models.Job;

/**
 *
 * @author LENOVO
 */
public class JobDAO {

    private Connection connection;

    public JobDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Job> getAll() {
        List<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM Job";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Job job = new Job(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4)
                );

                job.setJobId(resultSet.getString(1));
                job.setJobTitle(resultSet.getString(2));
                job.setJobMinSalary(resultSet.getDouble(3));
                job.setJobMaxSalary(resultSet.getDouble(4));
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }

    public boolean delete(Job job) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM JOB WHERE id = ?");
            preparedStatement.setString(1, job.getJobId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert(Job job) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO job(id, "
                    + "title, "
                    + "min_salary, "
                    + "max_salary) "
                    + "VALUES(?,?,?,?)");
            preparedStatement.setString(1, job.getJobId());
            preparedStatement.setString(2, job.getJobTitle());
            preparedStatement.setDouble(3, job.getJobMinSalary());
            preparedStatement.setDouble(4, job.getJobMaxSalary());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Job getById(String id) {
        String query = "SELECT * FROM job where id = ?";
        Job job = new Job();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));
                job.setJobMinSalary(rs.getDouble(3));
                job.setJobMaxSalary(rs.getDouble(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return job;
    }

    public boolean update(String id, Job job) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE job SET title=?, "
                    + "min_salary=?, "
                    + "max_salary=?, "
                    + "WHERE id=?");
            preparedStatement.setString(1, job.getJobTitle());
            preparedStatement.setDouble(2, job.getJobMinSalary());
            preparedStatement.setDouble(3, job.getJobMaxSalary());
            preparedStatement.setString(4, id);

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
