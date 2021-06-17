package com.kodlamaio.HRManageSystem.api.controller.resume;


import com.kodlamaio.HRManageSystem.business.abstracts.resume.ResumeService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.resume.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    ResumeService resumeService;
    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Resume>> getAll(){
        return this.resumeService.getAll();
    }
/*
    @PostMapping("/add")
    public Result add(@RequestBody Resume Resume,@RequestParam int userId){
        return this.resumeService.add(Resume,userId);
    }
*/
    //Her alanı doldurulabilen bir CV oluşturmak yerine boş CV oluşturulması ve daha sonra ilgili alanların bu CV ye atanmasını tercih ettim
@PostMapping("/add")
public Result add( String github, String linkedin, String description,@RequestParam int userID){
    return   this.resumeService.add(github,linkedin,description,userID);
}


    @GetMapping("/getByUserId")
    public DataResult<List<Resume>> getByUserId(@RequestParam int userId) {
        return  (this.resumeService.getByUserId(userId));
    }


}
