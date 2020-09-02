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


}
