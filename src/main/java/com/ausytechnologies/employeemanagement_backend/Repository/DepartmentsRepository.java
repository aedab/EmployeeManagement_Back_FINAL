package com.ausytechnologies.employeemanagement_backend.Repository;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {

    @Override
    List<Departments> findAll();

    Departments findById(int id);

}
