package com.ausytechnologies.employeemanagement_backend.Service;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.JobCategories;
import com.ausytechnologies.employeemanagement_backend.Repository.JobCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoriesService {

    @Autowired
    private JobCategoriesRepository jobCategoriesRepository;

    public JobCategories saveCategories(JobCategories jobCategory){
        return this.jobCategoriesRepository.save(jobCategory);
    }

    public JobCategories findById(int id){
        return this.jobCategoriesRepository.findById(id);
    }

    public List<JobCategories> findAllJobCategories(){
        return this.jobCategoriesRepository.findAll();
    }

}
