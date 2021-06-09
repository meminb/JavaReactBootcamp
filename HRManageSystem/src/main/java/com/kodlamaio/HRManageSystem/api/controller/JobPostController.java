package com.kodlamaio.HRManageSystem.api.controller;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kodlamaio.HRManageSystem.business.abstracts.JobPostService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.entities.concreates.City;
import com.kodlamaio.HRManageSystem.entities.concreates.Employer;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/JobPost")
public class JobPostController {

    private JobPostService jobPostService;


    @Autowired
    public JobPostController(JobPostService jobPostService){
        this.jobPostService=jobPostService;
    }



    @GetMapping("/getByActivity")
    public DataResult<List<JobPost>>getByActivity(){
       return this.jobPostService.getByActivity(true);

    }

    @GetMapping("/getByActivityAndEmployerId")
    public DataResult<List<JobPost>>getByActivityAndEmployerID(@RequestParam int userId){
        return this.jobPostService.getByActivityAndEmployerID(true,userId);

    }

    @GetMapping("/getAll")
    public DataResult<List<JobPost>>getAll(){
        return this.jobPostService.getAll();
    }

    @GetMapping("/getAllSortedByDate")
    public DataResult<List<JobPost>>getAllSortedByDate(){

        return this.jobPostService.getAllSortedByDate();
    }


    @PostMapping("/add")
    public Result add(String description,int maxSalary,int minSalary,String lastDay,int freePositions,int userId,int jobId,int cityId){


        // JobPost jobPost=new JobPost(0,description,maxSalary,minSalary,postDate,lastDay,true,freePositions,userId,job_id,cityId);
        return this.jobPostService.add(description,maxSalary,minSalary,lastDay,freePositions,userId,jobId,cityId);
    }

    @PostMapping("/updateActivity")
    public DataResult<JobPost> updateActivity(int postId){

         return this.jobPostService.updateActivity(postId);
    }
}
