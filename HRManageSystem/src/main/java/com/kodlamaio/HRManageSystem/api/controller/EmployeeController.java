package com.kodlamaio.HRManageSystem.api.controller;

import com.kodlamaio.HRManageSystem.business.abstracts.EmployeeServices;
import com.kodlamaio.HRManageSystem.business.abstracts.EmployerServices;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    EmployeeServices employeeServices;

    @Autowired
    public  EmployeeController(EmployeeServices employeeServices){
        this.employeeServices=employeeServices;

    }


    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll(){
        return this.employeeServices.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employee employee){
        return this.employeeServices.add(employee);
    }



}
