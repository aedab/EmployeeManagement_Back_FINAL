package com.ausytechnologies.employeemanagement_backend.Controller;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.Departments;
import com.ausytechnologies.employeemanagement_backend.Model.DAO.Employees;
import com.ausytechnologies.employeemanagement_backend.Service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        this.employeesService.deleteEmployeeById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "Deleted the employee with id " + id);
        return ResponseEntity.noContent().headers(httpHeaders).build();
    }

}
