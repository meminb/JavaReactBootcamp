package com.kodlamaio.HRManageSystem.api.controller.resume;

import com.kodlamaio.HRManageSystem.business.abstracts.resume.ExperienceService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Education;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService){
        this.experienceService=experienceService;

    }


    @GetMapping("/getByResumeIdSorted")
    public DataResult<List<Experience>> getByResumeIdSorted(@RequestParam int resumeId){

        return new SuccessDataResult<List<Experience>>(this.experienceService.getByResumeIdSorted(resumeId),"Data listed");
    }


    @PostMapping("/add")
    public Result add(@RequestParam int resumeId,@RequestParam String companyName, @RequestParam String positionName, @RequestParam String startDate, String endDate){
        return this.experienceService.add(resumeId,companyName,positionName,startDate,endDate);


    }







}
