package com.kodlamaio.HRManageSystem.api.controller.resume;

import com.kodlamaio.HRManageSystem.business.abstracts.resume.EducationService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.resumeDaos.EducationDao;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {


    EducationService educationService;


    @Autowired
    public EducationController(EducationService educationService){

        this.educationService=educationService;
    }



    @GetMapping("/getByResumeIdSorted")
    public DataResult<List<Education>> getByResumeIdSorted(@RequestParam int resumeId){

        return new SuccessDataResult<List<Education>>(this.educationService.getByResumeIdSorted(resumeId),"Data listed");
    }


    @PostMapping("/add")
    public Result add(@RequestParam  int resumeId,@RequestParam String schoolName,@RequestParam String departmentName,@RequestParam String startDate,String endDate){
        return   this.educationService.add( resumeId, schoolName, departmentName, startDate, endDate);


    }




}
