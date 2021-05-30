package com.kodlamaio.HRManageSystem.api.controller;

import com.kodlamaio.HRManageSystem.business.abstracts.EmployerServices;
import com.kodlamaio.HRManageSystem.business.abstracts.VerificationService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.Employer;
import com.kodlamaio.HRManageSystem.entities.concreates.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    EmployerServices employerServices;

    @Autowired
    public  EmployerController(EmployerServices employerServices){
        this.employerServices=employerServices;

    }


    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerServices.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return this.employerServices.add(employer);
    }

}
