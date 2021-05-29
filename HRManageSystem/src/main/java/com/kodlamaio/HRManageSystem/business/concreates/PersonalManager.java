package com.kodlamaio.HRManageSystem.business.concreates;

import com.kodlamaio.HRManageSystem.business.abstracts.PersonalService;
import com.kodlamaio.HRManageSystem.core.utilities.result.DataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.Result;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessDataResult;
import com.kodlamaio.HRManageSystem.core.utilities.result.SuccessResult;
import com.kodlamaio.HRManageSystem.dataAccess.abstracts.PersonalDao;
import com.kodlamaio.HRManageSystem.entities.concreates.JobPosition;
import com.kodlamaio.HRManageSystem.entities.concreates.Personals;
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
    public DataResult<List<Personals>> getAll() {
        return new SuccessDataResult<List<Personals>>(this.personalDao.findAll(),"Data Listed");
    }

    @Override
    public Result add(Personals personal) {
        this.personalDao.save(personal);
        return new SuccessResult("Personal added");
    }
}
