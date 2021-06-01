package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.EmployeeServices;
import com.kodlamaio.HRManageSystem.core.utilities.result.*;
import com.kodlamaio.HRManageSystem.core.validation.abstracts.EmployeeValidationService;
import com.kodlamaio.HRManageSystem.core.validation.concreate.EmployeeValidationManager;
import com.kodlamaio.HRManageSystem.core.verification.concreates.MernisManager;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.EmployeeDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.UserDao;
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
    EmployeeValidationService employeeValidationService;
   

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, UserDao userDao) {
        this.employeeDao = employeeDao;
        //need dependency injection here
        this.employeeValidationService = new EmployeeValidationManager(employeeDao,userDao,new MernisManager());

    }



    @Override
    public DataResult<List<Employee>> getAll() {

        return new SuccessDataResult<List<Personal>>(this.employeeDao.findAll(),"Employees Listed");
    }

    @Override
    public Result add(Employee employee) {

        if(!employeeValidationService.isAllFieldFilled(employee)){
            return new ErrorResult("You need to fill all the fields");
        }else if(!employeeValidationService.isEmailUnique(employee.getEmail())){
            return new ErrorResult("Email already used");
        }else if(!employeeValidationService.isIdUnique(employee.getIdNumber())){
            return new ErrorResult("Id number already used");
        }else if(!employeeValidationService.isMernisVerified(employee)){
            return new ErrorResult("Mernis verification failed");
        }

        this.employeeDao.save(employee);
        return new SuccessResult("Employee saved");
    }
}
