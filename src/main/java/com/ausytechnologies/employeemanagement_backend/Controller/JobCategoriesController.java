package com.ausytechnologies.employeemanagement_backend.Controller;

import com.ausytechnologies.employeemanagement_backend.Service.JobCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobcategories")
public class JobCategoriesController {

    @Autowired
    private JobCategoriesService jobCategoriesService;


}
