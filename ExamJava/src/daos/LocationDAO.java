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
import models.Location;

/**
 *
 * @author LENOVO
 */
public class LocationDAO {

    private Connection connection;

    public LocationDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        String query = "SELECT * FROM LOCATION";
        try {
            ResultSet resultSet = connection
                    .prepareStatement(query)
                    .executeQuery();
            while (resultSet.next()) {
                Location location = new Location(
                        resultSet.getInt(1), 
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
                
                location.setLocationId(resultSet.getInt(1));
                location.setLocationStreet(resultSet.getString(2));
                location.setLocationPostal(resultSet.getString(3));
                location.setLocationCity(resultSet.getString(4));
                location.setLocationState(resultSet.getString(5));
                location.setLocationCountry(resultSet.getString(6));
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }
    
     public boolean delete(Location location) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM location WHERE id = ?");
            preparedStatement.setInt(1, location.getLocationId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert(Location location) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO location(id, "
                    + "street_address, "
                    + "postal_code, "
                    + "city, "
                    + "state_province, "
                    + "country) "
                    + "VALUES(?,?,?,?,?,?)");
            preparedStatement.setInt(1, location.getLocationId());
            preparedStatement.setString(2, location.getLocationStreet());
            preparedStatement.setString(3, location.getLocationPostal());
            preparedStatement.setString(4, location.getLocationCity());
            preparedStatement.setString(5, location.getLocationState());
            preparedStatement.setString(6, location.getLocationCountry());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Location getById(int id) {
        String query = "SELECT * FROM location where id = ?";
        Location location = new Location();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                location.setLocationId(rs.getInt(1));
                location.setLocationStreet(rs.getString(2));
                location.setLocationPostal(rs.getString(3));
                location.setLocationCity(rs.getString(4));
                location.setLocationState(rs.getString(5));
                location.setLocationCountry(rs.getString(6));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
    }

    public boolean update(int id, Location location) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE location SET street_address=?, "
                    + "postal_code=?, "
                    + "city=?, "
                    + "state_province=?, "
                    + "country=? "
                    + "WHERE id=?");
            preparedStatement.setString(1, location.getLocationStreet());
            preparedStatement.setString(2, location.getLocationPostal());
            preparedStatement.setString(3, location.getLocationCity());
            preparedStatement.setString(4, location.getLocationState());
            preparedStatement.setString(5, location.getLocationCountry());
            preparedStatement.setInt(6, location.getLocationId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

