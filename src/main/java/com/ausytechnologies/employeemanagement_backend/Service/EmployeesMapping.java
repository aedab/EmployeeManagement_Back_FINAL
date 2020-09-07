package com.ausytechnologies.employeemanagement_backend.Service;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.Departments;
import com.ausytechnologies.employeemanagement_backend.Model.DAO.Employees;
import com.ausytechnologies.employeemanagement_backend.Model.DTO.EmployeesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeesMapping {

        public EmployeesDto convertToDto(Employees employee){

            EmployeesDto employeeDto = new EmployeesDto();
            employeeDto.setId(employee.getId());
            employeeDto.setFirstName(employee.getFirstName());
            employeeDto.setLastName(employee.getLastName());
            employeeDto.setManager(employee.isManager());
            employeeDto.setStartDate(employee.getStartDate());
            employeeDto.setDepartmentId(employee.getDepartmentId().getId());
            employeeDto.setJobCategoryId(employee.getJobCategoryId().getId());
            return employeeDto ;
        }
}
