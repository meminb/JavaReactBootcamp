package com.kodlamaio.HRManageSystem.api.controller;

import com.kodlamaio.HRManageSystem.business.abstracts.PersonalService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.abstracts.Entities;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import com.kodlamaio.HRManageSystem.entities.concreates.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personals")
public class PersonalController {
    private PersonalService personalService;

    @Autowired
    public PersonalController(PersonalService personalService){this.personalService = personalService;}

    @GetMapping("/getall")
    public DataResult<List<Personal>> getAll(){
        return this.personalService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Personal person){
        return this.personalService.add(person);
    }

/**/
    @GetMapping("/{id}")
    public Personal getDemoEntity(@PathVariable("id") int id) {

        List<Personal> list=this.personalService.getAll().getData();

        return list.get(id);
    }

    }


