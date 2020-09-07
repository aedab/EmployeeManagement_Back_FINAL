package com.ausytechnologies.employeemanagement_backend.Model.DAO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_categories")
public class JobCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "jobCategoryId",cascade = CascadeType.ALL)
    private List<Employees> employeesList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
