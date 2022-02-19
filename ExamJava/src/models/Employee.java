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
public class Employee {

    private int employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private String employeePhone;
    private String employeeHireDate;
    private String employeeJob;
    private Double employeeSalary;
    private Double employeeComission;
    private int employeeManager;
    private int employeeDepartment;

    public Employee() {

    }

    public Employee(
            int employeeId,
            String employeeFirstName,
            String employeeLastName,
            String employeeEmail,
            String employeePhone,
            String employeeHireDate,
            String employeeJob,
            Double employeeSalary,
            Double employeeComission,
            int employeeManager,
            int employeeDepartment
    ) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeHireDate = employeeHireDate;
        this.employeeJob = employeeJob;
        this.employeeSalary = employeeSalary;
        this.employeeComission = employeeComission;
        this.employeeManager = employeeManager;
        this.employeeDepartment = employeeDepartment;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(String employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public String getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public double getEmployeeComission() {
        return employeeComission;
    }

    public void setEmployeeComission(double employeeComission) {
        this.employeeComission = employeeComission;
    }

    public int getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(int employeeManager) {
        this.employeeManager = employeeManager;
    }

    public int getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(int employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public int getById() {
        return employeeId;
    }

    public Employee(int employeeId) {
        this.employeeId = employeeId;
    }

}
