package com.ausytechnologies.employeemanagement_backend.Controller;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.Departments;
import com.ausytechnologies.employeemanagement_backend.Service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Departments> saveDepartment(@RequestBody Departments department){

        Departments departmentAdded = this.departmentsService.saveDepartment(department);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Added new department");
        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(departmentAdded);
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Departments>> findAllDepartments(){

        List<Departments> departmentsList = this.departmentsService.findAllDepartments();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Found all the departments");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(departmentsList);

    }

    @GetMapping("/getDepartmentById/{id}")
    public ResponseEntity<Departments> getDepartmentById(@PathVariable int id){

        Departments departmentFound = this.departmentsService.findById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Found all the departments");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(departmentFound);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable int id){
        this.departmentsService.deleteDepartmentById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "Deleted the department with id " + id);
        return ResponseEntity.noContent().headers(httpHeaders).build();
    }


}
