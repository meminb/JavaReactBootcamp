package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.EmployeeServices;
import com.kodlamaio.HRManageSystem.business.abstracts.EmployerServices;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.EmployeeDao;
import com.kodlamaio.HRManageSystem.entities.concreates.Employee;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@SpringBootApplication
public class EmployeeManager implements EmployeeServices {

    EmployeeDao employeeDao;


    @Autowired
    public EmployeeManager(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;

    }



    @Override
    public DataResult<List<Employee>> getAll() {

        return new SuccessDataResult<List<Personal>>(this.employeeDao.findAll(),"Employees Listed");
    }

    @Override
    public Result add(Employee employee) {
        this.employeeDao.save(employee);
        return new SuccessResult("Employee Verified");
    }
}
