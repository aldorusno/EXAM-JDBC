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
public class Job {

    private String jobId;
    private String jobTitle;
    private double jobMinSalary;
    private double jobMaxSalary;
    
    public Job(){
        
    }

    public Job(
            String jobId,
            String jobTitle,
            double jobMinSalary,
            double jobMaxSalary
    ) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobMinSalary = jobMinSalary;
        this.jobMaxSalary = jobMaxSalary;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getJobMinSalary() {
        return jobMinSalary;
    }

    public void setJobMinSalary(double jobMinSalary) {
        this.jobMinSalary = jobMinSalary;
    }

    public double getJobMaxSalary() {
        return jobMaxSalary;
    }

    public void setJobMaxSalary(double jobMaxSalary) {
        this.jobMaxSalary = jobMaxSalary;
    }
    
    public String getById() {
        return jobId;
    }
    
     public Job(String jobId) {
        this.jobId = jobId;
    }

}
