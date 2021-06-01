package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.EmployerServices;
import com.kodlamaio.HRManageSystem.core.utilities.result.*;
import com.kodlamaio.HRManageSystem.core.validation.abstracts.EmployerValidationService;
import com.kodlamaio.HRManageSystem.core.validation.concreate.EmployerValidationManager;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.UserDao;
import com.kodlamaio.HRManageSystem.entities.concreates.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@SpringBootApplication
public class EmployerManager implements EmployerServices {

    EmployerValidationService employerValidationService;
    EmployerDao employerDao;
    @Autowired
    public EmployerManager(EmployerDao employerDao, UserDao userDao){
        this.employerDao=employerDao;
        this.employerValidationService=new EmployerValidationManager(userDao,employerDao);

    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<Employer>(this.employerDao.findAll(),"Employers Listed");
    }

    @Override
    public Result add(Employer employer) {
        if(!employerValidationService.isAllFieldFilled(employer)){
            return new ErrorResult("You need to fill all the fields");
        }else if (employerValidationService.isEmailUnique(employer.getEmail())){
            return new ErrorResult("Email already used");
        }else if(employerValidationService.isValidatedByPersonal(employer)){
            System.out.println("Need to validate");
        }


        this.employerDao.save(employer);
        return new SuccessResult("Employer added");
    }
}
