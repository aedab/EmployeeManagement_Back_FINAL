package com.ausytechnologies.employeemanagement_backend.Service;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.Departments;
import com.ausytechnologies.employeemanagement_backend.Repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsService {

    @Autowired
    private DepartmentsRepository departmentsRepository;

    public Departments saveDepartment(Departments department) {

        return this.departmentsRepository.save(department);
    }

    public Departments findById(int id){
        return this.departmentsRepository.findById(id);
    }

    public List<Departments> findAllDepartments(){
        return this.departmentsRepository.findAll();
    }
}
