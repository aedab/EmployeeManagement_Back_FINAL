package com.ausytechnologies.employeemanagement_backend.Service;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.Departments;
import com.ausytechnologies.employeemanagement_backend.Model.DAO.Employees;
import com.ausytechnologies.employeemanagement_backend.Model.DAO.JobCategories;
import com.ausytechnologies.employeemanagement_backend.Repository.DepartmentsRepository;
import com.ausytechnologies.employeemanagement_backend.Repository.EmployeesRepository;
import com.ausytechnologies.employeemanagement_backend.Repository.JobCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Employees saveEmployee(Employees employee){
        return this.employeesRepository.save(employee);
    }

    public Employees findEmployeeById(int id){
        return this.employeesRepository.findById(id);
    }

    public List<Employees> findAllEmployees(){
        return this.employeesRepository.findAll();

    }



}

