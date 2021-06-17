package com.kodlamaio.HRManageSystem.api.controller.resume;

import com.kodlamaio.HRManageSystem.business.abstracts.resume.TechnologyService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Experience;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {

    TechnologyService technologyService;
    @Autowired
    public TechnologyController(TechnologyService technologyService){

        this.technologyService=technologyService;
    }


    @GetMapping("/getByResumeId")
    public DataResult<List<Experience>> getByResumeId(@RequestParam int resumeId){

        return new SuccessDataResult<List<Technology>>(this.technologyService.getByResumeId(resumeId),"Data listed");
    }


    @PostMapping("/add")
    public Result add(@RequestParam int resumeId, @RequestParam String techName){
        return  this.technologyService.add(resumeId,techName);


    }




}
