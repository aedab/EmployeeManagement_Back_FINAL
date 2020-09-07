package com.ausytechnologies.employeemanagement_backend.Service;

import com.ausytechnologies.employeemanagement_backend.Exception.ErrorNotFound;
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
        Departments department = this.departmentsRepository.findById(id);
        if(department == null) throw new ErrorNotFound(id);
        return department;
    }

    public List<Departments> findAllDepartments(){

            List<Departments> departmentsList = this.departmentsRepository.findAll();
            if(departmentsList.isEmpty()) throw new ErrorNotFound();
            return departmentsList;
    }

    public void deleteDepartmentById(int id){
        this.departmentsRepository.deleteById(id);
    }
}
