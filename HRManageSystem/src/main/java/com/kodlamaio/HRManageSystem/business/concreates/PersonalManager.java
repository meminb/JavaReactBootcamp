package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.PersonalService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.PersonalDao;
import com.kodlamaio.HRManageSystem.entities.abstracts.Entities;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
@SpringBootApplication
public class PersonalManager implements PersonalService {

    private PersonalDao personalDao;

    @Autowired
    public PersonalManager(PersonalDao personalDao){
        this.personalDao=personalDao;
    }

    @Override
    public DataResult<List<Personal>> getAll() {
        return new SuccessDataResult<List<Personal>>(
                this.personalDao.findAll(),"Personals Listed");
    }

    @Override
    public Result add(Personal personal) {
        this.personalDao.save(personal);
        return new SuccessResult("Personal added");
    }
}
