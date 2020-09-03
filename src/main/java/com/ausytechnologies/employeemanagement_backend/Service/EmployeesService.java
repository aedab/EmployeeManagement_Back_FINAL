package com.ausytechnologies.employeemanagement_backend.Service;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.Departments;
import com.ausytechnologies.employeemanagement_backend.Model.DAO.Employees;
import com.ausytechnologies.employeemanagement_backend.Model.DAO.JobCategories;
import com.ausytechnologies.employeemanagement_backend.Repository.DepartmentsRepository;
import com.ausytechnologies.employeemanagement_backend.Repository.EmployeesRepository;
import com.ausytechnologies.employeemanagement_backend.Repository.JobCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private DepartmentsRepository departmentsRepository;
    @Autowired
    private  JobCategoriesRepository jobCategoriesRepository;

    public Employees saveEmployee(Employees employee, int idDepartment, int idJobCategory){
        //return this.employeesRepository.save(employee);
        Departments department = this.departmentsRepository.findById(idDepartment);
        JobCategories jobCategory = this.jobCategoriesRepository.findById(idJobCategory);

        if(department!=null && jobCategory != null) {
            employee.setDepartmentId(department);
            employee.setJobCategoryId(jobCategory);
            return this.employeesRepository.save(employee);
        }
        else
        {
            throw new RuntimeException("Department or JobCategory not found");
        }

    }

    public Employees findEmployeeById(int id){
        return this.employeesRepository.findById(id);
    }

    public List<Employees> findAllEmployees(){
        return this.employeesRepository.findAll();

    }

    public void deleteEmployeeById(int id){
        this.employeesRepository.deleteById(id);
    }

    public List<Employees>  findEmployeesByDepartment(int idDepartment){
        List<Employees> employeesList = this.employeesRepository.findAll();
        List<Employees> employeesFound = new ArrayList<>();
        for(int i = 0; i < employeesList.size(); i++){
            if(employeesList.get(i).getDepartmentId().equals(departmentsRepository.findById(idDepartment))){
                employeesFound.add(employeesList.get(i));
            }
        }
        return employeesFound;
    }

    public List<Employees> findEmployeesByJob(int idJobCategory ){
        List<Employees> employeesList = this.employeesRepository.findAll();
        List<Employees> employeesFound = new ArrayList<>();

        for(int i = 0; i < employeesList.size(); i++){
            if(employeesList.get(i).getJobCategoryId().equals(jobCategoriesRepository.findById(idJobCategory))){
                employeesFound.add(employeesList.get(i));
            }
        }
        return employeesFound;
    }


    public List<Employees> findEmployeesByDepartmentAndJob (int idDepartment, int idJobCategory ){
        List<Employees> employeesList = this.employeesRepository.findAll();
        List<Employees> employeesFound = new ArrayList<>();

        for(int i = 0; i < employeesList.size(); i++){
            if(employeesList.get(i).getJobCategoryId().equals(jobCategoriesRepository.findById(idJobCategory)) &&
            employeesList.get(i).getDepartmentId().equals(departmentsRepository.findById(idDepartment))){
                employeesFound.add(employeesList.get(i));
            }
        }
        return employeesFound;
    }


}

