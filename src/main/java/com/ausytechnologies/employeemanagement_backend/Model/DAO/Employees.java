package com.ausytechnologies.employeemanagement_backend.Model.DAO;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "isManager")
    private boolean isManager;
    @Column(name = "startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @Column(name = "endDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    @Column(name = "isActive")
    private boolean isActive;
    @Column(name = "address")
    private String address;
    @Column(name = "cp")
    private String cp;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthday;
    @Column(name = "noChildren")
    private int noChildren;
    @Column(name = "salary")
    private double salary;
    @Column(name = "studies")
    private String studies;
    @Column(name = "socialSecurityNumber")
    private String socialSecurityNumber;
    @Column(name = "hasDrivingLicense")
    private boolean hasDrivingLicense;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "departmentId")
    private Departments departmentId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "jobCategoryId")
    private JobCategories jobCategoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getNoChildren() {
        return noChildren;
    }

    public void setNoChildren(int noChildren) {
        this.noChildren = noChildren;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public boolean isHasDrivingLicense() {
        return hasDrivingLicense;
    }

    public void setHasDrivingLicense(boolean hasDrivingLicense) {
        this.hasDrivingLicense = hasDrivingLicense;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    public JobCategories getJobCategoryId() {
        return jobCategoryId;
    }

    public void setJobCategoryId(JobCategories jobCategoryId) {
        this.jobCategoryId = jobCategoryId;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isManager=" + isManager +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActive=" + isActive +
                ", address='" + address + '\'' +
                ", cp='" + cp + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", noChildren=" + noChildren +
                ", salary=" + salary +
                ", studies='" + studies + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", hasDrivingLicense=" + hasDrivingLicense +
                ", departmentId=" + departmentId +
                '}';
    }
}
