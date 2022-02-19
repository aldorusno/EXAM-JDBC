/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author LENOVO
 */
public class Location {

    private int locationId;
    private String locationStreet;
    private String locationPostal;
    private String locationCity;
    private String locationState;
    private String locationCountry;

    public Location() {

    }

    public Location(
            int locationId,
            String locationStreet,
            String locationPostal,
            String locationCity,
            String locationState,
            String locationCountry
    ) {
        this.locationId = locationId;
        this.locationStreet = locationStreet;
        this.locationPostal = locationPostal;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.locationCountry = locationCountry;

    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationStreet() {
        return locationStreet;
    }

    public void setLocationStreet(String locationStreet) {
        this.locationStreet = locationStreet;
    }

    public String getLocationPostal() {
        return locationPostal;
    }

    public void setLocationPostal(String locationPostal) {
        this.locationPostal = locationPostal;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public int getById() {
        return locationId;
    }

    public Location(int locationId) {
        this.locationId = locationId;
    }

}
