/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author LENOVO
 */
import daos.RegionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Region;
import daos.RegionDAO;
import models.Location;
import daos.LocationDAO;
import models.Country;
import daos.CountryDAO;
import models.Department;
import daos.DepartmentDAO;
import models.Employee;
import daos.EmployeeDAO;
import models.Job;
import daos.JobDAO;

public class Test {

    public static void main(String[] args) {
        DbConnection connection = new DbConnection();
//        System.out.println(connection.getConnection());

        RegionDAO rdao = new RegionDAO(connection.getConnection());
        CountryDAO cdao = new CountryDAO(connection.getConnection());
        LocationDAO ldao = new LocationDAO(connection.getConnection());
        DepartmentDAO ddao = new DepartmentDAO(connection.getConnection());
        JobDAO jdao = new JobDAO(connection.getConnection());
        EmployeeDAO edao = new EmployeeDAO(connection.getConnection());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih tabel dibawah ini");
        System.out.println("1. Region");
        System.out.println("2. Country");
        System.out.println("3. Location");
        System.out.println("4. Department");
        System.out.println("5. Job");
        System.out.println("6. Employee");
        System.out.println("\n");
        System.out.print("Masukkan pilihan anda : ");
        int pilih = scanner.nextInt();

        boolean stop = false;
        while (!stop) {
            switch (pilih) {
                case 1:
                    System.out.println("Tabel Region");
                    System.out.println("Pilih operasi yang dilakukan");
                    System.out.println("1. Show");
                    System.out.println("2. Insert");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("\n");
                    System.out.print("Masukkan pilihan anda : ");
                    int pRegion = scanner.nextInt();
                    boolean stopRegion = false;
                    while (!stopRegion) {
                        switch (pRegion) {
                            case 1:
                                for (Region region : rdao.getAll()) {
                                    System.out.print("ID : ");
                                    System.out.println(region.getRegionId());
                                    System.out.print("Nama Region : ");
                                    System.out.println(region.getRegionName());
                                }
                                stopRegion = true;
                                break;
                            case 2:
                                System.out.print("Masukkan id region baru : ");
                                int regionId = scanner.nextInt();

                                System.out.print("Masukkan nama region baru : ");
                                scanner.nextLine();
                                String regionName = scanner.nextLine();

                                Region addRegion = new Region(regionId, regionName);
                                System.out.println(rdao.insert(addRegion));
                                stopRegion = true;
                                break;
                            case 3:
                                System.out.print("Masukkan id region yang akan diupdate : ");
                                int getId = scanner.nextInt();

                                System.out.print("Nama region lama : ");
                                System.out.println(rdao.getById(getId).getRegionName());
                                System.out.print("Nama region baru : ");
                                scanner.nextLine();
                                String name = scanner.nextLine();

                                Region up = new Region(getId, name);
                                System.out.println(rdao.update(getId, up));
                                stopRegion = true;
                                break;
                            case 4:
                                System.out.print("Masukkan id region yang akan dihapus : ");
                                int deleteId = scanner.nextInt();
                                Region delRegion = new Region(deleteId);
                                System.out.println(rdao.delete(delRegion));
                                stopRegion = true;
                                break;
                            default:
                                stopRegion = true;
                                break;
                        }
                    }
                    stop = true;
                    break;

                case 2:
                    System.out.println("Tabel Country");
                    System.out.println("Pilih operasi yang dilakukan");
                    System.out.println("1. Show");
                    System.out.println("2. Insert");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("\n");
                    System.out.print("Masukkan pilihan anda : ");
                    int pCountry = scanner.nextInt();
                    boolean stopCountry = false;
                    while (!stopCountry) {
                        switch (pCountry) {
                            case 1:
                                for (Country country : cdao.getAll()) {
                                    System.out.print("ID : ");
                                    System.out.println(country.getCountryId());
                                    System.out.print("Name : ");
                                    System.out.println(country.getCountryName());
                                    System.out.print("Region : ");
                                    System.out.println(country.getCountryRegion());
                                }
                                stopCountry = true;
                                break;

                            case 2:
                                System.out.print("Masukkan id country baru : ");
                                scanner.nextLine();
                                String countryId = scanner.nextLine();

                                System.out.print("Masukkan nama country baru : ");
                                String countryName = scanner.nextLine();

                                System.out.print("Masukkan region : ");
                                int countryRegion = scanner.nextInt();

                                Country addCountry = new Country(countryId, countryName, countryRegion);
                                System.out.println(cdao.insert(addCountry));
                                stopCountry = true;
                                break;

                            case 3:
                                System.out.print("Masukkan id country yang akan diupdate : ");
                                scanner.nextLine();
                                String getId = scanner.nextLine();
                                System.out.print("Nama country lama : ");
                                System.out.println(cdao.getById(getId).getCountryName());
                                System.out.print("Nama country baru : ");

                                String name = scanner.nextLine();
                                System.out.print("Region country lama : ");
                                System.out.println(cdao.getById(getId).getCountryRegion());
                                System.out.print("Region country baru : ");
                                int region = scanner.nextInt();

                                Country up = new Country(getId, name, region);
                                System.out.println(cdao.update(getId, up));
                                stopCountry = true;
                                break;

                            case 4:
                                System.out.print("Masukkan id country yang akan dihapus : ");
                                scanner.nextLine();
                                String id = scanner.nextLine();
                                Country del = new Country(id);
                                System.out.println(cdao.delete(del));
                                stopCountry = true;
                                break;
                            default:
                                stopCountry = true;
                                break;
                        }
                    }
                    stop = true;
                    break;

                case 3:
                    System.out.println("Tabel Location");
                    System.out.println("Pilih operasi yang dilakukan");
                    System.out.println("1. Show");
                    System.out.println("2. Insert");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("\n");
                    System.out.print("Masukkan pilihan anda : ");
                    int pLocation = scanner.nextInt();
                    boolean stopLocation = false;
                    while (!stopLocation) {
                        switch (pLocation) {
                            case 1:
                                for (Location location : ldao.getAll()) {
                                    System.out.print("ID : ");
                                    System.out.println(location.getLocationId());
                                    System.out.print("Street Address : ");
                                    System.out.println(location.getLocationStreet());
                                    System.out.print("Postal Code : ");
                                    System.out.println(location.getLocationPostal());
                                    System.out.print("City : ");
                                    System.out.println(location.getLocationCity());
                                    System.out.print("State : ");
                                    System.out.println(location.getLocationState());
                                    System.out.print("Country : ");
                                    System.out.println(location.getLocationCountry());
                                }
                                stopLocation = true;
                                break;
                            case 2:
                                System.out.print("Masukkan id location baru : ");
                                scanner.nextLine();
                                int locationId = scanner.nextInt();
                                System.out.print("Masukkan nama street address : ");
                                scanner.nextLine();
                                String locationStreet = scanner.nextLine();

                                System.out.print("Masukkan postal code : ");
                                String locationPostal = scanner.nextLine();
                                System.out.print("Masukkan city : ");
                                String locationCity = scanner.nextLine();
                                System.out.print("Masukkan state province : ");
                                String locationState = scanner.nextLine();
                                System.out.print("Masukkan country : ");
                                String locationCountry = scanner.nextLine();

                                Location addLocation = new Location(
                                        locationId,
                                        locationStreet,
                                        locationPostal,
                                        locationCity,
                                        locationState,
                                        locationCountry
                                );
                                System.out.println(ldao.insert(addLocation));
                                stopLocation = true;
                                break;
                            case 3:
                                System.out.print("Masukkan id location yang akan diupdate : ");
                                scanner.nextLine();
                                int getId = scanner.nextInt();
                                System.out.print("Nama street address lama : ");
                                System.out.println(ldao.getById(getId).getLocationStreet());
                                System.out.print("Nama street address baru : ");
                                scanner.nextLine();
                                String street = scanner.nextLine();

                                System.out.print("Postal code lama : ");
                                System.out.println(ldao.getById(getId).getLocationPostal());
                                System.out.print("Postal code baru : ");
                                String postal = scanner.nextLine();

                                System.out.print("City lama : ");
                                System.out.println(ldao.getById(getId).getLocationCity());
                                System.out.print("City baru : ");
                                String city = scanner.nextLine();

                                System.out.print("State province lama : ");
                                System.out.println(ldao.getById(getId).getLocationState());
                                System.out.print("State province baru : ");
                                String state = scanner.nextLine();

                                System.out.print("Country lama : ");
                                System.out.println(ldao.getById(getId).getLocationCountry());
                                System.out.print("country baru : ");
                                String country = scanner.nextLine();

                                Location up = new Location(getId, street, postal, city, state, country);
                                System.out.println(ldao.update(getId, up));
                                stopLocation = true;
                                break;

                            case 4:
                                System.out.print("Masukkan id country yang akan dihapus : ");
                                int id = scanner.nextInt();
                                Location del = new Location(id);
                                System.out.println(ldao.delete(del));
                                stopLocation = true;
                                break;
                            default:
                                stopLocation = true;
                                break;
                        }
                    }
                    stop = true;
                    break;

                case 4:
                    System.out.println("Tabel Department");
                    System.out.println("Pilih operasi yang dilakukan");
                    System.out.println("1. Show");
                    System.out.println("2. Insert");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("\n");
                    System.out.print("Masukkan pilihan anda : ");
                    int pDepartment = scanner.nextInt();
                    boolean stopDepartment = false;
                    while (!stopDepartment) {
                        switch (pDepartment) {
                            case 1:
                                for (Department department : ddao.getAll()) {
                                    System.out.print("ID : ");
                                    System.out.println(department.getDepartmentId());
                                    System.out.print("Name : ");
                                    System.out.println(department.getDepartmentName());
                                    System.out.print("Manager : ");
                                    System.out.println(department.getDepartmentManager());
                                    System.out.print("Location : ");
                                    System.out.println(department.getDepartmentLocation());
                                }
                                stopDepartment = true;
                                break;
                            case 2:
                                System.out.print("Masukkan id department baru : ");
                                scanner.nextLine();
                                int departmentId = scanner.nextInt();
                                System.out.print("Masukkan nama department : ");
                                scanner.nextLine();
                                String departmentName = scanner.nextLine();

                                System.out.print("Masukkan manager : ");
                                int departmentManager = scanner.nextInt();
                                System.out.print("Masukkan location : ");
                                int departmentLocation = scanner.nextInt();

                                Department addDepartment = new Department(
                                        departmentId,
                                        departmentName,
                                        departmentManager,
                                        departmentLocation
                                );
                                System.out.println(ddao.insert(addDepartment));
                                stopDepartment = true;
                                break;
                            case 3:
                                System.out.print("Masukkan id department yang akan diupdate : ");
                                scanner.nextLine();
                                int getId = scanner.nextInt();
                                System.out.print("Nama department lama : ");
                                System.out.println(ddao.getById(getId).getDepartmentName());
                                System.out.print("Nama department baru : ");
                                scanner.nextLine();
                                String name = scanner.nextLine();

                                System.out.print("Manager lama : ");
                                System.out.println(ddao.getById(getId).getDepartmentManager());
                                System.out.print("Manager baru : ");
                                int manager = scanner.nextInt();

                                System.out.print("Location lama : ");
                                System.out.println(ddao.getById(getId).getDepartmentLocation());
                                System.out.print("Location baru : ");
                                int location = scanner.nextInt();

                                Department up = new Department(getId, name, manager, location);
                                System.out.println(ddao.update(getId, up));
                                stopDepartment = true;
                                break;
                            case 4:
                                System.out.print("Masukkan id department yang akan dihapus : ");
                                int id = scanner.nextInt();
                                Department del = new Department(id);
                                System.out.println(ddao.delete(del));
                                stopDepartment = true;
                                break;
                            default:
                                stopDepartment = true;
                                break;
                        }
                    }
                    stop = true;
                    break;

                case 5:
                    System.out.println("Tabel Job");
                    System.out.println("Pilih operasi yang dilakukan");
                    System.out.println("1. Show");
                    System.out.println("2. Insert");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("\n");
                    System.out.print("Masukkan pilihan anda : ");
                    int pJob = scanner.nextInt();
                    boolean stopJob = false;
                    while (!stopJob) {
                        switch (pJob) {
                            case 1:
                                for (Job job : jdao.getAll()) {
                                    System.out.print("ID : ");
                                    System.out.println(job.getJobId());
                                    System.out.print("Name : ");
                                    System.out.println(job.getJobTitle());
                                    System.out.print("Manager : ");
                                    System.out.println(job.getJobMinSalary());
                                    System.out.print("Location : ");
                                    System.out.println(job.getJobMaxSalary());
                                }
                                stopJob = true;
                                break;
                            case 2:
                                System.out.print("Masukkan id job baru : ");
                                scanner.nextLine();
                                String jobId = scanner.nextLine();
                                System.out.print("Masukkan title job : ");
                                String jobTitle = scanner.nextLine();

                                System.out.print("Masukkan min salary : ");
                                double jobMinSalary = scanner.nextDouble();
                                System.out.print("Masukkan max salary : ");
                                double jobMaxSalary = scanner.nextDouble();

                                Job addJob = new Job(
                                        jobId,
                                        jobTitle,
                                        jobMinSalary,
                                        jobMaxSalary
                                );
                                System.out.println(jdao.insert(addJob));
                                stopJob = true;
                                break;
                            case 3:
                                System.out.print("Masukkan id job yang akan diupdate : ");
                                scanner.nextLine();
                                String getId = scanner.nextLine();
                                
                                System.out.print("Nama title job lama : ");
                                System.out.println(jdao.getById(getId).getJobTitle());
                                System.out.print("Nama title job baru : ");
                                String name = scanner.nextLine();

                                System.out.print("Manager lama : ");
                                System.out.println(jdao.getById(getId).getJobMinSalary());
                                System.out.print("Manager baru : ");
                                double minSalary = scanner.nextDouble();

                                System.out.print("Location lama : ");
                                System.out.println(jdao.getById(getId).getJobMaxSalary());
                                System.out.print("Location baru : ");
                                double maxSalary = scanner.nextDouble();

                                Job up = new Job(getId, name, minSalary, maxSalary);
                                System.out.println(jdao.update(getId, up));
                                stopJob = true;
                                break;
                            case 4:
                                System.out.print("Masukkan id job yang akan dihapus : ");
                                scanner.nextLine();
                                String id = scanner.nextLine();
                                Job del = new Job(id);
                                System.out.println(jdao.delete(del));
                                stopJob = true;
                                break;
                            default:
                                stopJob = true;
                                break;
                        }
                    }
                    stop = true;
                    break;

                case 6:
                    System.out.println("Tabel Employee");
                    System.out.println("Pilih operasi yang dilakukan");
                    System.out.println("1. Show");
                    System.out.println("2. Insert");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("\n");
                    System.out.print("Masukkan pilihan anda : ");
                    int pEmployee = scanner.nextInt();
                    boolean stopEmployee = false;
                    while (!stopEmployee) {
                        switch (pEmployee) {
                            case 1:
                                for (Employee employee : edao.getAll()) {
                                    System.out.print("ID : ");
                                    System.out.println(employee.getEmployeeId());
                                    System.out.print("First name : ");
                                    System.out.println(employee.getEmployeeFirstName());
                                    System.out.print("Last name : ");
                                    System.out.println(employee.getEmployeeLastName());
                                    System.out.print("Email : ");
                                    System.out.println(employee.getEmployeeEmail());
                                    System.out.print("Phone : ");
                                    System.out.println(employee.getEmployeePhone());
                                    System.out.print("HireDate : ");
                                    System.out.println(employee.getEmployeeHireDate());
                                    System.out.print("Job : ");
                                    System.out.println(employee.getEmployeeJob());
                                    System.out.print("Salary : ");
                                    System.out.println(employee.getEmployeeSalary());
                                    System.out.print("Comission : ");
                                    System.out.println(employee.getEmployeeComission());
                                    System.out.print("Manager : ");
                                    System.out.println(employee.getEmployeeManager());
                                    System.out.print("Department : ");
                                    System.out.println(employee.getEmployeeDepartment());
                                }
                                stopEmployee = true;
                                break;
                            case 2:
                                System.out.print("Masukkan id employee baru : ");
                                scanner.nextLine();
                                int employeeId = scanner.nextInt();
                                
                                System.out.print("Masukkan first name : ");
                                scanner.nextLine();
                                String employeeFirstName = scanner.nextLine();
                                
                                System.out.print("Masukkan last name : ");
                                String employeeLastName = scanner.nextLine();
                                
                                System.out.print("Masukkan email : ");
                                String employeeEmail = scanner.nextLine();
                                
                                System.out.print("Masukkan phone number : ");
                                String employeePhone = scanner.nextLine();

                                System.out.print("Masukkan hire date : ");
                                String employeeHireDate = scanner.nextLine();

                                System.out.print("Masukkan job title : ");
                                String employeeJob = scanner.nextLine();

                                System.out.print("Masukkan salary : ");
                                double employeeSalary = scanner.nextDouble();
                                
                                System.out.print("Masukkan comission : ");
                                double employeeComission = scanner.nextDouble();

                                System.out.print("Masukkan manager : ");
                                int employeeManager = scanner.nextInt();
                                
                                System.out.print("Masukkan department : ");
                                int employeeDepartment = scanner.nextInt();

                                Employee addEmployee = new Employee(
                                        employeeId,
                                        employeeFirstName,
                                        employeeLastName,
                                        employeeEmail,
                                        employeePhone,
                                        employeeHireDate,
                                        employeeJob,
                                        employeeSalary,
                                        employeeComission,
                                        employeeManager,
                                        employeeDepartment
                                );
                                System.out.println(edao.insert(addEmployee));
                                stopEmployee = true;
                                break;
                            case 3:
                                System.out.print("Masukkan id employee yang akan diupdate : ");
                                scanner.nextLine();
                                int getId = scanner.nextInt();

                                System.out.print("Nama first name lama : ");
                                System.out.println(edao.getById(getId).getEmployeeFirstName());
                                System.out.print("Nama first name baru : ");
                                scanner.nextLine();
                                String firstName = scanner.nextLine();

                                System.out.print("Nama last name lama : ");
                                System.out.println(edao.getById(getId).getEmployeeLastName());
                                System.out.print("Nama last name baru : ");
                                String lastName = scanner.nextLine();

                                System.out.print("Nama email lama : ");
                                System.out.println(edao.getById(getId).getEmployeeEmail());
                                System.out.print("Nama email baru : ");
                                String email = scanner.nextLine();

                                System.out.print("Phone number lama : ");
                                System.out.println(edao.getById(getId).getEmployeePhone());
                                System.out.print("Phone number baru : ");
                                String phone = scanner.nextLine();

                                System.out.print("Hire date lama : ");
                                System.out.println(edao.getById(getId).getEmployeeHireDate());
                                System.out.print("Hire date baru : ");
                                String hireDate = scanner.nextLine();

                                System.out.print("Job title lama : ");
                                System.out.println(edao.getById(getId).getEmployeeJob());
                                System.out.print("Job title baru : ");
                                String job = scanner.nextLine();

                                System.out.print("Salary lama : ");
                                System.out.println(edao.getById(getId).getEmployeeSalary());
                                System.out.print("Salary baru : ");
                                double salary = scanner.nextDouble();

                                System.out.print("Comission lama : ");
                                System.out.println(edao.getById(getId).getEmployeeComission());
                                System.out.print("Comission baru : ");
                                double comission = scanner.nextDouble();

                                System.out.print("Manager lama : ");
                                System.out.println(edao.getById(getId).getEmployeeManager());
                                System.out.print("Manager baru : ");
                                int manager = scanner.nextInt();

                                System.out.print("Department lama : ");
                                System.out.println(edao.getById(getId).getEmployeeDepartment());
                                System.out.print("Department baru : ");
                                int department = scanner.nextInt();

                                Employee up = new Employee(getId, firstName, lastName, email, phone, hireDate, job, salary, comission, manager, department);
                                System.out.println(edao.update(getId, up));
                                stopEmployee = true;
                                break;
                            case 4:
                                System.out.print("Masukkan id employee yang akan dihapus : ");
                                int id = scanner.nextInt();
                                Employee del = new Employee(id);
                                System.out.println(edao.delete(del));
                                stopEmployee = true;
                                break;
                            default:
                                stopEmployee = true;
                                break;
                        }
                    }
                    stop = true;
                    break;
                default:
                    stop = true;
                    break;
            }
        }

    }
}
