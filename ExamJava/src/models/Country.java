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
public class Country {

    private String countryId;
    private String countryName;
    private int countryRegion;

    public Country() {
    }

    public Country(String countryId) {
        this.countryId = countryId;
    }

    public Country(
            String countryId,
            String countryName,
            int countryRegion
    ) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryRegion = countryRegion;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(int countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getById() {
        return countryId;
    }
}
