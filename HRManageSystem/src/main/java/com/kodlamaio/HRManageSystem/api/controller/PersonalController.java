package com.kodlamaio.HRManageSystem.api.controller;

import com.kodlamaio.HRManageSystem.business.abstracts.PersonalService;
import com.kodlamaio.HRManageSystem.business.concreates.PersonalManager;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.Personals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personals")
public class PersonalController {
    private PersonalService personalService;

    @Autowired
    public PersonalController(PersonalService personalService){this.personalService=personalService;}

    @GetMapping("/getall")
    public DataResult<List<Personals>> gelAll(){
        return this.personalService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Personals person){
        return this.personalService.add(person);
    }


}
