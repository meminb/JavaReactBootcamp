package com.kodlamaio.HRManageSystem.api.controller;

import com.kodlamaio.HRManageSystem.business.abstracts.VerificationService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import com.kodlamaio.HRManageSystem.entities.concreates.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verifications")
public class VerificationController {

    VerificationService verificationService;


    @Autowired
    public  VerificationController(VerificationService verificationService){
        this.verificationService=verificationService;

    }


    @GetMapping("/getall")
    public DataResult<List<Verification>> getAll(){
        return this.verificationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Verification verification){
        return this.verificationService.add(verification);
    }






}
