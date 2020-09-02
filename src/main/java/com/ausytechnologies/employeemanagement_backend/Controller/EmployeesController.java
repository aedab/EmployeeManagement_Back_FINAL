package com.ausytechnologies.employeemanagement_backend.Controller;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.Departments;
import com.ausytechnologies.employeemanagement_backend.Model.DAO.Employees;
import com.ausytechnologies.employeemanagement_backend.Model.DAO.JobCategories;
import com.ausytechnologies.employeemanagement_backend.Service.DepartmentsService;
import com.ausytechnologies.employeemanagement_backend.Service.EmployeesService;
import com.ausytechnologies.employeemanagement_backend.Service.JobCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private DepartmentsService departmentsService;
    @Autowired
    private JobCategoriesService jobCategoriesService;

    @PostMapping("/addEmployee/{idDepartment}/{idJobCategory}")
    public ResponseEntity<Employees> addEmployee(@RequestBody Employees employee, @PathVariable int idDepartment, @PathVariable int idJobCategory){
        Employees employeeAdded = this.employeesService.saveEmployee(employee,idDepartment,idJobCategory);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Added new employee");
        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(employeeAdded);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employees>> getAllEmployees(){
        List<Employees> employeesFound = this.employeesService.findAllEmployees();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Added new employee");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employeesFound);
    }
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employees> getAllEmployees(@PathVariable int id){
        Employees employeeFound = this.employeesService.findEmployeeById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Added new employee");
        return ResponseEntity.status(HttpStatus.FOUND).headers(httpHeaders).body(employeeFound);
    }

    @PutMapping("/updateEmployee/{id}/{idDepartment}/{idJobCategory}")
    public ResponseEntity<Employees> updateEmployee(@RequestBody Employees employee,
                                                    @PathVariable int id, @PathVariable int idDepartment,
                                                    @PathVariable int idJobCategory){
        Employees employeeToBeUpdated = this.employeesService.findEmployeeById(id);

        employeeToBeUpdated.setFirstName(employee.getFirstName());
        employeeToBeUpdated.setLastName(employee.getLastName());
        employeeToBeUpdated.setManager(employee.isManager());
        employeeToBeUpdated.setStartDate(employee.getStartDate());
        employeeToBeUpdated.setEndDate(employee.getEndDate());
        employeeToBeUpdated.setActive(employee.isActive());
        employeeToBeUpdated.setAddress(employee.getAddress());
        employeeToBeUpdated.setCp(employee.getCp());
        employeeToBeUpdated.setTelephone(employee.getTelephone());
        employeeToBeUpdated.setEmail(employee.getEmail());
        employeeToBeUpdated.setBirthday(employee.getBirthday());
        employeeToBeUpdated.setNoChildren(employee.getNoChildren());
        employeeToBeUpdated.setSalary(employee.getSalary());
        employeeToBeUpdated.setStudies(employee.getStudies());
        employeeToBeUpdated.setSocialSecurityNumber(employee.getSocialSecurityNumber());
        employeeToBeUpdated.setHasDrivingLicense(employee.isHasDrivingLicense());


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Employee updated successfully");
        this.employeesService.saveEmployee(employeeToBeUpdated,idDepartment,idJobCategory);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).headers(httpHeaders).body(employeeToBeUpdated);

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        this.employeesService.deleteEmployeeById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "Deleted the employee with id " + id);
        return ResponseEntity.noContent().headers(httpHeaders).build();
    }

}
