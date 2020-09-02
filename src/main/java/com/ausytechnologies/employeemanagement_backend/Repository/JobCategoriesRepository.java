package com.ausytechnologies.employeemanagement_backend.Repository;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.JobCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobCategoriesRepository extends JpaRepository<JobCategories, Integer> {

    @Override
    List<JobCategories> findAll();

    JobCategories findById(int id);
}
