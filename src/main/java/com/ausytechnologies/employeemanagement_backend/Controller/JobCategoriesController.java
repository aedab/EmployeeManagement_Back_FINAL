package com.ausytechnologies.employeemanagement_backend.Controller;

import com.ausytechnologies.employeemanagement_backend.Model.DAO.JobCategories;
import com.ausytechnologies.employeemanagement_backend.Service.JobCategoriesService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobcategories")
public class JobCategoriesController {

    @Autowired
    private JobCategoriesService jobCategoriesService;

    @PostMapping("/addJobCategory")
    public ResponseEntity<JobCategories> addJobCategory(@RequestBody JobCategories jobCategories){
        JobCategories jobAdded = this.jobCategoriesService.saveJobCategory(jobCategories);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Added new job category");
        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(jobAdded);
    }

    @GetMapping("/getAllJobCategories")
    public ResponseEntity<List<JobCategories>> getAllJobCategories(){
        List<JobCategories> getAllJobs = this.jobCategoriesService.findAllJobCategories();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded","Found all job categories!");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(getAllJobs);
    }


    @DeleteMapping("/deleteJobCategory/{id}")
    public ResponseEntity<Void> deleteJobCategory(@PathVariable int id){
        this.jobCategoriesService.deleteJobCategoryById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "Deleted the job category with id " + id);
        return ResponseEntity.noContent().headers(httpHeaders).build();
    }
}
