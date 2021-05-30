package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.EmployerServices;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.EmployerDao;
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

    EmployerDao employerDao;


    @Autowired
    public EmployerManager(EmployerDao employerDao){
        this.employerDao=employerDao;


    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<Employer>(this.employerDao.findAll(),"Employers Listed");
    }

    @Override
    public Result add(Employer employer) {
        return null;
    }
}
