package com.kodlamaio.HRManageSystem.api.controller.resume;


import com.kodlamaio.HRManageSystem.business.abstracts.resume.LanguageService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Experience;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api/language")
public class LanguageController {

    LanguageService languageService;

    @Autowired

    public LanguageController(LanguageService languageService){this. languageService=languageService;}



    @GetMapping("/getByResumeId")
    public DataResult<List<Language>> getByResumeId(@RequestParam int resumeId){

        return new SuccessDataResult<List<Experience>>(this.languageService.getByResumeId(resumeId),"Data listed");
    }


    @PostMapping("/add")
    public Result add(@RequestParam int resumeId, @RequestParam String languageName, @RequestParam int level){
        return this.languageService.add(resumeId,languageName,level);

    }



}
