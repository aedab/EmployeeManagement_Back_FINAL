package com.ausytechnologies.employeemanagement_backend.Repository;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    @Override
    List<Employees> findAll();

    Employees findById(int id);
}
