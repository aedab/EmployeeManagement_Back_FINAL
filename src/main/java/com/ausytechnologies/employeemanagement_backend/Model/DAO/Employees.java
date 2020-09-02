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

    @Transient
    private boolean isManager;
    @Column(name = "startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @Column(name = "endDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate endDate;

    @Transient
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
    @Transient
    private boolean hasDrivingLicense;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "departmentId")
    private Departments departmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jobCategoryId")
    private JobCategories jobCategoryId;


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
